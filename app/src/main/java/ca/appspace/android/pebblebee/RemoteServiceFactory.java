package ca.appspace.android.pebblebee;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import ca.appspace.android.pebblebee.ecobee.ApiRequest;
import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
import ca.appspace.android.pebblebee.ecobee.Selection;
import ca.appspace.android.pebblebee.ecobee.SelectionType;
import ca.appspace.android.pebblebee.ecobee.SelectionTypeJsonAdapter;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by eugene on 2015-02-08.
 */
public class RemoteServiceFactory {

    private final static String TAG = RemoteServiceFactory.class.getSimpleName();

    private final static String CLIENT_ID = "mobile";
    private final static String SERVER_ADDR = "https://api.ecobee.com";

    private final static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
		    .registerTypeAdapter(SelectionType.class, new SelectionTypeJsonAdapter())
            .create();


	public static void main(String... args) {
		ApiRequest req = new ApiRequest();
		req.setSelection(new Selection());
		req.setSelection(new Selection());
		req.getSelection().setSelectionType(SelectionType.THERMOSTATS);
		req.getSelection().setSelectionMatch("");
		req.getSelection().setIncludeDevice(true);
		req.getSelection().setIncludeEvents(true);
		req.getSelection().setIncludeRuntime(true);
		System.out.println(gson.toJson(req));

		System.out.println(gson.toJson(SelectionType.THERMOSTATS));

		System.out.println(gson.fromJson(SelectionType.THERMOSTATS.asJsonValue(), SelectionType.class));
	}

    public static EcobeeAPI createEcobeeApi(Context context) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setClient(new OkClient())
                .setConverter(new GsonConverter(gson))
                .setEndpoint(SERVER_ADDR)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
	                @Override
	                public void log(String message) {
		                Log.d(TAG, message);
	                }
                })
                .build();
        return restAdapter.create(EcobeeAPI.class);
    }

	public static EcobeeAPI createSecuredEcobeeApi(Context context, RequestInterceptor requestInterceptor) {
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setClient(new OkClient())
				.setConverter(new GsonConverter(gson))
				.setEndpoint(SERVER_ADDR)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setRequestInterceptor(requestInterceptor)
				.setLog(new RestAdapter.Log() {
					@Override
					public void log(String message) {
						Log.d(TAG, message);
					}
				})
				.build();
		return restAdapter.create(EcobeeAPI.class);
	}

}
