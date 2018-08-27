package com.kahvedunyasi.barista.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.kahvedunyasi.barista.R;

import java.util.ArrayList;

public final class AppUtils {
    private static final String PREF_KEY_TOKEN = "PREF_KEY_TOKEN";
    private static final String PREF_KEY_LONGITUDE = "PREF_KEY_LONGITUDE";
    private static final String PREF_KEY_LATITUDE = "PREF_KEY_LATITUDE";
    private AppUtils() {
        // This class is not publicly instantiable
    }

    public static void openPlayStoreForApp(Context context) {
        final String appPackageName = context.getPackageName();
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_market_link) + appPackageName)));
        } catch (android.content.ActivityNotFoundException e) {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .getResources()
                            .getString(R.string.app_google_play_store_link) + appPackageName)));
        }
    }

    public static String getToken(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        return preferences.getString(PREF_KEY_TOKEN, "");
    }

    public static void setToken(Context context, String token) {
        SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = preferences.edit();
        prefEdit.putString(PREF_KEY_TOKEN, token);
        prefEdit.apply();
    }

    public static void setLastLocation(Context context, double latitude, double longitude) {
        SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = preferences.edit();
        prefEdit.putString(PREF_KEY_LONGITUDE, String.valueOf(longitude));
        prefEdit.putString(PREF_KEY_LATITUDE, String.valueOf(latitude));
        prefEdit.apply();
    }

    public static ArrayList<Double> getLastLocation(Context context) {
        ArrayList<Double> locationInfo = new ArrayList<>();
        SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        double lat = Double.parseDouble(preferences.getString(PREF_KEY_LATITUDE, "0"));
        double lng = Double.parseDouble(preferences.getString(PREF_KEY_LONGITUDE, "0"));
        locationInfo.add(lat);
        locationInfo.add(lng);
        return locationInfo;
    }
}
