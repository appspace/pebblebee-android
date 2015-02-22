package ca.appspace.android.pebblebee;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.concurrent.locks.ReentrantLock;

import ca.appspace.android.pebblebee.ecobee.ApiRequest;
import ca.appspace.android.pebblebee.ecobee.AuthorizeResponse;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import ca.appspace.android.pebblebee.ecobee.ThermostatData;
import ca.appspace.android.pebblebee.ecobee.TokenResponse;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Query;

/**
 * Created by eugene on 2015-02-21.
 */
public class AuthApiWrapper extends Service implements EcobeeAPI {

	private final static String TAG = AuthApiWrapper.class.getSimpleName();

	private String _oauthCode;
	private String _oauthRefreshCode;
	private long _oauthExpiresIn;

	private final IBinder _binder = new LocalBinder();

	private EcobeeAPI _api;
	private EcobeeAPI _insecuredApi;

	private ReentrantLock _oauthRefreshLock = new ReentrantLock();

	public class LocalBinder extends Binder {
		AuthApiWrapper getService() {
			return AuthApiWrapper.this;
		}
	}


	@Override
	public void authorize(String responseType, String clientId, String scope, Callback<AuthorizeResponse> callback) {

	}

	@Override
	public void token(String grantType, String authCode,
	                  String clientId, Callback<TokenResponse> callback) {

	}

	@Override
	public void getThermostats(ApiRequest request, Callback<ThermostatData> callback) {
		refreshTokenIfRequired();
		_api.getThermostats(request, callback);
	}

	private void refreshTokenIfRequired() {
		Log.d(TAG, "Checking if refresh token is required");
		if (_oauthExpiresIn<1 || System.currentTimeMillis()>_oauthExpiresIn) {
			_oauthRefreshLock.tryLock();
			Log.d(TAG, "Requesting new code as previous has expired");
			_insecuredApi.token("ecobeePin", _oauthRefreshCode, EcobeeAPI.API_KEY, new Callback<TokenResponse>() {
				@Override
				public void success(TokenResponse tokenResponse, Response response) {
					_oauthExpiresIn = System.currentTimeMillis()+tokenResponse.getExpiresIn()*60*1000;
					_oauthCode = tokenResponse.getAccessToken();
					_oauthRefreshCode = tokenResponse.getRefreshToken();
					Log.d(TAG, "New access token loaded: "+_oauthCode);
					_oauthRefreshLock.unlock();
				}

				@Override
				public void failure(RetrofitError error) {
					Log.e(TAG, "Error refreshing code "+error.getResponse().getReason());
					_oauthRefreshLock.unlock();
				}
			});
		} else {
			Log.d(TAG, "Code is still OK for next "+((_oauthExpiresIn-System.currentTimeMillis())/1000)+" seconds");
		}

		while (_oauthRefreshLock.isLocked()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
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
