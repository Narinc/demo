package com.kahvedunyasi.barista.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.di.scope.ApplicationContext;
import com.kahvedunyasi.barista.di.scope.PreferenceInfo;
import com.kahvedunyasi.barista.util.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

  private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
  private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
  private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
  private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
  private static final String PREF_KEY_CURRENT_USER_IMAGE = "PREF_KEY_CURRENT_USER_IMAGE";
  private static final String PREF_KEY_CURRENT_USER_PIN =  "PREF_KEY_CURRENT_USER_PIN";
  private static final String PREF_KEY_CURRENT_USER_LOCALE = "PREF_KEY_CURRENT_USER_LOCALE";

  private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

  private final SharedPreferences mPrefs;

  @Inject
  public AppPreferencesHelper(@ApplicationContext Context context,
      @PreferenceInfo String prefFileName) {
    mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
  }

  @Override
  public String getCurrentUserId() {
    String userId = mPrefs.getString(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
    return userId == AppConstants.NULL_INDEX ? null : userId;
  }

  @Override
  public void setCurrentUserId(String userId) {
    String id = userId == null ? AppConstants.NULL_INDEX : userId;
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, id).apply();
  }

  @Override
  public String getCurrentUserName() {
    return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
  }

  @Override
  public void setCurrentUserName(String userName) {
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
  }

  @Override
  public String getCurrentUserEmail() {
    return mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
  }

  @Override
  public void setCurrentUserEmail(String email) {
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply();
  }

  @Override
  public String getCurrentUserImage() {
    return mPrefs.getString(PREF_KEY_CURRENT_USER_IMAGE, null);
  }

  @Override
  public void setCurrentUserImage(String userImage) {
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_IMAGE, userImage).apply();
  }

  @Override
  public int getCurrentUserLoggedInMode() {
    return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
        DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
  }

  @Override
  public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
    mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
  }

  @Override
  public String getCurrentUserLanguage() {
    return mPrefs.getString(PREF_KEY_CURRENT_USER_LOCALE, "tr");
  }

  @Override
  public void setCurrentUserLanguage(String locale) {
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_LOCALE, locale).apply();
  }

  @Override
  public String getCurrentUserPin() {
    return mPrefs.getString(PREF_KEY_CURRENT_USER_PIN, null);
  }

  @Override
  public void setCurrentUserPin(String pin) {
    mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PIN, pin).apply();
  }

  @Override
  public String getCurrentUserAccessToken() {
    return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
  }

  @Override
  public void setCurrentUserAccessToken(String token) {
    mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, token).apply();
  }

}
