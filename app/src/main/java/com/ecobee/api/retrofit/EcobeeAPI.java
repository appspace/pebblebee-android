package com.ecobee.api.retrofit;

import java.io.Serializable;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 *
 * @param <R> type of ApiRequest - String.class or ApiRequest.class
 */
public interface EcobeeAPI<R extends Serializable> {


    final static long PIN_MAX_LIFE = 10*60*1000;    //10 minutes

    //'https://api.ecobee.com/authorize?response_type=ecobeePin&client_id=APPLICATION_KEY&scope=smartWrite'
    @GET("/authorize")
    public void authorize(
            @Query("response_type") String responseType,
            @Query("client_id") String clientId,
            @Query("scope") String scope,
            Callback<AuthorizeResponse> callback);

    /*
        POST https://api.ecobee.com/token?grant_type=ecobeePin&code=AUTHORIZATION_TOKEN&client_id=APP_KEY
    */
    @POST("/token")
    public void token(
            @Query("grant_type") String grantType,
            @Query("code") String authCode,
            @Query("client_id") String clientId,
            Callback<TokenResponse> callback
            );

    @GET("/1/thermostat")
    public void getThermostats(
            @Query("json") R request,
            Callback<ThermostatData> callback);

	@GET("/1/thermostatSummary")
	public void getThermostatSummary(
			@Query("json") R request,
	        Callback<ThermostatSummary> callback);

}
