package com.kahvedunyasi.barista.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class LoyaltyLocationProvider {

    public static final int LOCATION_REQUEST_CODE = 7171;
    private final LocationListener locationListener;
    private FusedLocationProviderClient mFusedLocationClient;

    private LocationRequest mLocationRequest;


    //TODO: Sets when implementation and test done.
    private static int UPDATE_INTERVAL = 1000 * 30; // SEC
    private static int FASTEST_INTERVAL = 1000 * 5; // SEC
    private Context context;

    LocationCallback locationCallBack = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                locationListener.onLocationChanged(locationResult.getLastLocation());
            }
    };

    public void buildGoogleApiClient() {
        startLocationUpdates(locationCallBack);
    }

    public LoyaltyLocationProvider(Context context, @NonNull LocationListener locationListener) {
        this.context = context;
        this.locationListener = locationListener;
        getLocationClient();
    }

    private FusedLocationProviderClient getLocationClient() {
        if (mFusedLocationClient == null)
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        return mFusedLocationClient;
    }

    // Trigger new location updates at interval
    @SuppressLint("MissingPermission")
    private void startLocationUpdates(LocationCallback locationCallBack) {
        // Create the location request to start receiving updates
        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);

        getLocationClient().requestLocationUpdates(mLocationRequest, locationCallBack, Looper.myLooper());

        //TODO: delete before release
//        if (BuildConfig.DEBUG)
//            Toast.makeText(context, "start location updates", Toast.LENGTH_SHORT).show();
    }

    public void stopLocationUpdates() {
        getLocationClient().removeLocationUpdates(locationCallBack);
        getLocationClient().flushLocations();

        //TODO: delete before release
//        if (BuildConfig.DEBUG)
//            Toast.makeText(context, "stop location updates", Toast.LENGTH_SHORT).show();
    }

}
