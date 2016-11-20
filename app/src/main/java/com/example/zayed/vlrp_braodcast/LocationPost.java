package com.example.zayed.vlrp_braodcast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationPost {

    @SerializedName("VehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("Latitude")
    @Expose
    private String latitude;

    /**
     * 
     * @return
     *     The vehicleId
     */
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * 
     * @param vehicleId
     *     The VehicleId
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The Longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The Latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    LocationPost(String vehicleId,String longitude,String latitude)
    {
        this.vehicleId=vehicleId;
        this.longitude=longitude;
        this.latitude=latitude;
    }

}
