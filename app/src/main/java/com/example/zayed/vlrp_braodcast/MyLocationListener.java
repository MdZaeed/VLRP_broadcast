package com.example.zayed.vlrp_braodcast;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
        String longitude = "Longitude: " + loc.getLongitude();
        Log.d("Longitude: ", longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.d("Latitude: ", latitude);

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