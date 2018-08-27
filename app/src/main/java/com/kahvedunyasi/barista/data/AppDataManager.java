package com.kahvedunyasi.barista.data;


import android.content.Context;


import com.kahvedunyasi.barista.data.local.prefs.PreferencesHelper;
import com.kahvedunyasi.barista.di.scope.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

  private static final String TAG = "AppDataManager";

  private final Context mContext;
  private final PreferencesHelper mPreferencesHelper;

  @Inject
  public AppDataManager(@ApplicationContext Context context,
      PreferencesHelper preferencesHelper) {
    mContext = context;
    mPreferencesHelper = preferencesHelper;
  }

  @Override
  public String getCurrentUserId() {
    return mPreferencesHelper.getCurrentUserId();
  }

  @Override
  public void setCurrentUserId(String userId) {
    mPreferencesHelper.setCurrentUserId(userId);
  }

  @Override
  public String getCurrentUserName() {
    return mPreferencesHelper.getCurrentUserName();
  }

  @Override
  public void setCurrentUserName(String userName) {
    mPreferencesHelper.setCurrentUserName(userName);
  }

  @Override
  public String getCurrentUserEmail() {
    return mPreferencesHelper.getCurrentUserEmail();
  }

  @Override
  public void setCurrentUserEmail(String email) {
    mPreferencesHelper.setCurrentUserEmail(email);
  }

  @Override
  public String getCurrentUserImage() {
    return mPreferencesHelper.getCurrentUserImage();
  }

  @Override
  public void setCurrentUserImage(String userImage) {
    mPreferencesHelper.setCurrentUserImage(userImage);
  }

  @Override
  public int getCurrentUserLoggedInMode() {
    return mPreferencesHelper.getCurrentUserLoggedInMode();
  }

  @Override
  public void setCurrentUserLoggedInMode(LoggedInMode mode) {
    mPreferencesHelper.setCurrentUserLoggedInMode(mode);
  }

  @Override
  public String getCurrentUserLanguage() {
    return mPreferencesHelper.getCurrentUserLanguage();
  }

  @Override
  public void setCurrentUserLanguage(String locale) {
    mPreferencesHelper.setCurrentUserLanguage(locale);
  }

  @Override
  public String getCurrentUserPin() {
    return mPreferencesHelper.getCurrentUserPin();
  }

  @Override
  public void setCurrentUserPin(String pin) {
    mPreferencesHelper.setCurrentUserPin(pin);
  }

  public String getCurrentUserAccessToken() {
    return mPreferencesHelper.getCurrentUserAccessToken();
  }

  @Override
  public void setCurrentUserAccessToken(String token) {
    mPreferencesHelper.setCurrentUserAccessToken("Bearer " + token);
  }

  @Override
  public void setUserAsLoggedOut() {
    updateUserInfo(
        null,
        DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
        null,
        null);
  }

  @Override
  public void updateUserInfo(
      String userId,
      LoggedInMode loggedInMode,
      String userName,
      String email) {

    setCurrentUserId(userId);
    setCurrentUserLoggedInMode(loggedInMode);
    setCurrentUserName(userName);
    setCurrentUserEmail(email);

  }
}
