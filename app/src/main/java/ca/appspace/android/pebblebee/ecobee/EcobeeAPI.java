package ca.appspace.android.pebblebee.ecobee;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface EcobeeAPI {

    final static String API_KEY = "anMH4MUjBVKEaUhlum2K315xC6oH4uP2";
    final static long PIN_MAX_LIFE = 10*60*1000;    //10 minutes

    //'https://api.ecobee.com/authorize?response_type=ecobeePin&client_id=APPLICATION_KEY&scope=smartWrite'
    @GET("/authorize")
    public void authorize(
            @Query("response_type") String responseType,
            @Query("client_id") String clientId,
            @Query("scope") String scope,
            Callback<AuthorizeResponse> callback);

}
