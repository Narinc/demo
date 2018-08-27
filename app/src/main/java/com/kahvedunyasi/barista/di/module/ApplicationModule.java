package com.kahvedunyasi.barista.di.module;

import android.app.Application;
import android.content.Context;

import com.kahvedunyasi.barista.data.AppDataManager;
import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.data.local.prefs.AppPreferencesHelper;
import com.kahvedunyasi.barista.data.local.prefs.PreferencesHelper;
import com.kahvedunyasi.barista.di.scope.ApplicationContext;
import com.kahvedunyasi.barista.di.scope.PreferenceInfo;
import com.kahvedunyasi.barista.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

  private final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @PreferenceInfo
  String providePreferenceName() {
    return AppConstants.PREF_NAME;
  }

  @Provides
  @Singleton
  DataManager provideDataManager(AppDataManager appDataManager) {
    return appDataManager;
  }

  @Provides
  @Singleton
  PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
    return appPreferencesHelper;
  }

}
