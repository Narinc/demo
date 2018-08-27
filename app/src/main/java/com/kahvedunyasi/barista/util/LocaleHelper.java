package com.kahvedunyasi.barista.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;


public class LocaleHelper {

  private static final String PREF_KEY_CURRENT_USER_LOCALE = "PREF_KEY_CURRENT_USER_LOCALE";

  public static Context onAttach(Context context) {
    String lang = getPersistedData(context);
    return setLocale(context, lang);
  }

  public static String getLanguage(Context context) {
    return getPersistedData(context);
  }

  public static Context setLocale(Context context, String language) {
    persist(context, language);

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      return updateResources(context, language);
    }

    return updateResourcesLegacy(context, language);
  }

  private static String getPersistedData(Context context) {
    SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
    return preferences.getString(PREF_KEY_CURRENT_USER_LOCALE, "tr");
  }

  private static void persist(Context context, String language) {
    SharedPreferences preferences = context.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    editor.putString(PREF_KEY_CURRENT_USER_LOCALE, language);
    editor.apply();
  }

  @TargetApi(Build.VERSION_CODES.N)
  private static Context updateResources(Context context, String language) {
    Locale locale = new Locale(language);
    Locale.setDefault(locale);

    Configuration configuration = context.getResources().getConfiguration();
    configuration.setLocale(locale);
    configuration.setLayoutDirection(locale);

    return context.createConfigurationContext(configuration);
  }

  @SuppressWarnings("deprecation")
  private static Context updateResourcesLegacy(Context context, String language) {
    Locale locale = new Locale(language);
    Locale.setDefault(locale);

    Resources resources = context.getResources();

    Configuration configuration = resources.getConfiguration();
    configuration.locale = locale;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      configuration.setLayoutDirection(locale);
    }

    resources.updateConfiguration(configuration, resources.getDisplayMetrics());

    return context;
  }
}