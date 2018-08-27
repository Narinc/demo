package com.kahvedunyasi.barista.di.component;

import android.app.Application;
import android.content.Context;

import com.kahvedunyasi.barista.BaseApplication;
import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.di.module.ApplicationModule;
import com.kahvedunyasi.barista.di.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
