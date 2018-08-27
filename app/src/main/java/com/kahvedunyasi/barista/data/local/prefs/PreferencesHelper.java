package com.kahvedunyasi.barista.data.local.prefs;


import com.kahvedunyasi.barista.data.DataManager;

public interface PreferencesHelper {

  String getCurrentUserId();

  void setCurrentUserId(String userId);

  String getCurrentUserName();

  void setCurrentUserName(String userName);

  String getCurrentUserEmail();

  void setCurrentUserEmail(String email);

  String getCurrentUserImage();

  void setCurrentUserImage(String userImage);

  int getCurrentUserLoggedInMode();

  void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

  String getCurrentUserLanguage();

  void setCurrentUserLanguage(String locale);

  String getCurrentUserPin();

  void setCurrentUserPin(String pin);

  String getCurrentUserAccessToken();

  void setCurrentUserAccessToken(String token);
}
