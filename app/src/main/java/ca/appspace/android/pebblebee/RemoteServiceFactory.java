package ca.appspace.android.pebblebee;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ca.appspace.android.pebblebee.ecobee.EcobeeAPI;
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
            .create();

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
}
