package com.kahvedunyasi.barista.data;


import com.kahvedunyasi.barista.data.local.prefs.PreferencesHelper;

public interface DataManager extends PreferencesHelper {

  void setUserAsLoggedOut();

  void updateUserInfo(
          String userId,
          LoggedInMode loggedInMode,
          String userName,
          String email);

  enum LoggedInMode {

    LOGGED_IN_MODE_LOGGED_OUT(0),
    LOGGED_IN_MODE_LOGGED_IN(1);

    private final int mType;

    LoggedInMode(int type) {
      mType = type;
    }

    public int getType() {
      return mType;
    }
  }
}
