package com.example.zayed.vlrp_braodcast;

import org.json.JSONObject;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by BS-86 on 4/15/2016.
 */
public interface VlrpApi {

/*    @GET("/api/Vehicles")
    Call<List<VehicleResponse>> getAllVehicle(@Header("Auth-key") String authuytr);*/

/*    @POST("/api/login")
    Call<LoginResponse> login(@Body LoginPost loginPost);*/

    @POST("/api/location")
    Call<JSONObject> locationBroadcast(@Body LocationPost locationPost);
}