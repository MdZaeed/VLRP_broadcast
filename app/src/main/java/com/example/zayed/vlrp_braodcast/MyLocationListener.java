package com.example.zayed.vlrp_braodcast;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/*---------- Listener class to get coordinates ------------- */
class MyLocationListener implements LocationListener {

    Context context;
    public MyLocationListener(Context context)
    {
        this.context=context;
    }

    @Override
    public void onLocationChanged(Location loc) {
/*        editLocation.setText("");
        pb.setVisibility(View.INVISIBLE);*/
/*        Toast.makeText(context,
                "Location changed: Lat: " + loc.getLatitude() + " Lng: "
                    + loc.getLongitude(), Toast.LENGTH_SHORT).show();*/
        String longitude = "" + loc.getLongitude();
        Log.d("Longitude: ", longitude);
        String latitude = "" + loc.getLatitude();
        Log.d("Latitude: ", latitude);

        ApiAdapter apiAdapter=new ApiAdapter();
        Call<JSONObject> call=apiAdapter.vlrpApi.locationBroadcastForLive("6",latitude,longitude);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
                Log.d("Yes",response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Yes","Network error");
            }
        });

/*        LocationPost locationPost=new LocationPost(Tools.vehicleid,longitude,latitude);

        ApiAdapter apiAdapter=new ApiAdapter();
        Call<JSONObject> call=apiAdapter.vlrpApi.locationBroadcast(locationPost);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Response<JSONObject> response, Retrofit retrofit) {
                Log.d("Yes",response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Yes","Network error");
            }
        });*/
/*
        Call<List<VehicleGetResponse>> call1=apiAdapter.vlrpApi.locationBroadcast();
        call1.enqueue(new Callback<List<VehicleGetResponse>>() {
            @Override
            public void onResponse(Response<List<VehicleGetResponse>> response, Retrofit retrofit) {
                Log.d("Yes",response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Yes","Network error");
            }
        });*/

        /*------- To get city name from coordinates -------- */
/*        String cityName = null;
        Geocoder gcd = new Geocoder(context, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = gcd.getFromLocation(loc.getLatitude(),
                    loc.getLongitude(), 1);
            if (addresses.size() > 0) {
                System.out.println(addresses.get(0).getLocality());
                cityName = addresses.get(0).getLocality();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String s = longitude + "\n" + latitude + "\n\nMy Current City is: "
            + cityName;*/
/*        editLocation.setText(s);*/
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}
}