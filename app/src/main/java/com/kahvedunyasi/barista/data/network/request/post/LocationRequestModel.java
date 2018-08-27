package com.kahvedunyasi.barista.data.network.request.post;

import java.util.ArrayList;

public class LocationRequestModel {

    private double lat;
    private double lng;

    private LocationRequestModel(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LocationRequestModel(ArrayList<Double> location) {
        this(location.get(0), location.get(1));
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
