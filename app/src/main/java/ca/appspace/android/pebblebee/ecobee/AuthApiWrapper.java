package ca.appspace.android.pebblebee.ecobee;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import com.ecobee.api.retrofit.AuthorizeResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.appspace.android.pebblebee.ApplicationPreferences;

import com.ecobee.api.retrofit.ApiError;
import com.ecobee.api.retrofit.ApiRequest;

import com.ecobee.api.retrofit.EcobeeAPI;
import com.ecobee.api.retrofit.SelectionType;
import com.ecobee.api.retrofit.adapter.SelectionTypeJsonAdapter;
import com.ecobee.api.retrofit.ThermostatData;
import com.ecobee.api.retrofit.ThermostatSummary;
import com.ecobee.api.retrofit.TokenResponse;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Query;

/**
 * Created by eugene on 2015-02-21.
 */
public class AuthApiWrapper extends Service implements EcobeeAPI<ApiRequest> {

	private final static String TAG = AuthApiWrapper.class.getSimpleName();

	private String _oauthCode;
	private String _oauthRefreshCode;
	private long _oauthExpiresIn;

	private final IBinder _binder = new LocalBinder();

	private EcobeeAPI _api;
	private EcobeeAPI<String> _insecuredApi;

	private final static Gson gson = new GsonBuilder()
			.setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
			.registerTypeAdapter(SelectionType.class, new SelectionTypeJsonAdapter())
			.create();

	public class LocalBinder extends Binder {
		public AuthApiWrapper getService() {
			return AuthApiWrapper.this;
		}
	}

	@Override
	public void authorize(@Query("response_type") String responseType, @Query("client_id") String clientId, @Query("scope") String scope, Callback<AuthorizeResponse> callback) {

	}

	@Override
	public void token(@Query("grant_type") String grantType, @Query("code") String authCode, @Query("client_id") String clientId, Callback<TokenResponse> callback) {

	}

	@Override
	public void getThermostats(final ApiRequest request, final Callback<ThermostatData> callback) {
		refreshTokenIfRequired(new Callback<Void>() {
			@Override
			public void success(Void aVoid, Response response) {
				_api.getThermostats(gson.toJson(request), callback);
			}

			@Override
			public void failure(RetrofitError error) {
				callback.failure(error);
			}
		});
	}

	@Override
	public void getThermostatSummary(final ApiRequest request, final Callback<ThermostatSummary> callback) {
		refreshTokenIfRequired(new Callback<Void>() {
			@Override
			public void success(Void aVoid, Response response) {
				_api.getThermostatSummary(gson.toJson(request), new Callback<ThermostatSummary>() {
					@Override
					public void success(ThermostatSummary thermostatSummary, Response response) {
						callback.success(thermostatSummary, response);
					}

					@Override
					public void failure(RetrofitError error) {
						callback.failure(error);
					}
				});
			}

			@Override
			public void failure(RetrofitError error) {
				callback.failure(error);
			}
		});
	}

	private void refreshTokenIfRequired(final Callback<Void> tokenReadyCallback) {
		Log.d(TAG, "Checking if refresh token is required");
		if (_oauthExpiresIn<1 || System.currentTimeMillis()>_oauthExpiresIn) {
			Log.d(TAG, "Requesting new code as previous has expired");
			try {
				_insecuredApi.token("refresh_token", _oauthRefreshCode, ApplicationPreferences.ECOBEE_API_KEY, new Callback<TokenResponse>() {
					@Override
					public void success(TokenResponse tokenResponse, Response response) {
						_oauthExpiresIn = System.currentTimeMillis() + (tokenResponse.getExpiresIn() * 60 * 1000);
						_oauthCode = tokenResponse.getAccessToken();
						_oauthRefreshCode = tokenResponse.getRefreshToken();
						Log.d(TAG, "New access token loaded: " + _oauthCode);
						if (tokenReadyCallback!=null) tokenReadyCallback.success(null, response);
					}

					@Override
					public void failure(RetrofitError error) {
						try {
							ApiError bodyStr = (ApiError) error.getBodyAs(ApiError.class);
						} catch (RuntimeException e) {
							Log.e(TAG, "Error converting error response", e);
						}

						Log.e(TAG, "Error refreshing code " + error.getResponse().getReason());
						if (tokenReadyCallback!=null) tokenReadyCallback.failure(error);
					}
				});
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
				if (tokenReadyCallback!=null) tokenReadyCallback.failure(null);
			}
		} else {
			Log.d(TAG, "Code is still OK for next " + ((_oauthExpiresIn - System.currentTimeMillis()) / 1000) + " seconds");
			if (tokenReadyCallback!=null) tokenReadyCallback.success(null, null);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		_oauthRefreshCode = PreferenceManager.getDefaultSharedPreferences(this).getString(ApplicationPreferences.KEY_OAUTH_REFRESH_CODE, null);
		_oauthCode = PreferenceManager.getDefaultSharedPreferences(this).getString(ApplicationPreferences.KEY_OAUTH_CODE, null);
		_oauthExpiresIn = PreferenceManager.getDefaultSharedPreferences(this).getLong(ApplicationPreferences.KEY_OAUTH_CODE_EXPIRES_IN, 0);
		_api = RemoteServiceFactory.createSecuredEcobeeApi(this, new RequestInterceptor() {

			@Override
			public void intercept(RequestFacade request) {
				request.addHeader("Content-Type", "application/json;charset=UTF-8");
				request.addHeader("Authorization", "Bearer " + _oauthCode);
			}
		});

		_insecuredApi = RemoteServiceFactory.createEcobeeApi(this);

		return _binder;
	}

	/**
	 * ConnectivityManager connMgr = (ConnectivityManager)
	 getSystemService(Context.CONNECTIVITY_SERVICE);
	 NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	 if (networkInfo != null && networkInfo.isConnected()) {

	 */



}
