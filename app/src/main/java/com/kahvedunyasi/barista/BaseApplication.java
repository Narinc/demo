package com.kahvedunyasi.barista;

import android.app.Application;

import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.di.component.ApplicationComponent;
import com.kahvedunyasi.barista.di.component.DaggerApplicationComponent;
import com.kahvedunyasi.barista.di.component.DaggerNetworkComponent;
import com.kahvedunyasi.barista.di.component.NetworkComponent;
import com.kahvedunyasi.barista.di.module.ApplicationModule;
import com.kahvedunyasi.barista.di.module.NetworkModule;
import com.facebook.FacebookSdk;

import javax.inject.Inject;

public class BaseApplication extends Application {

    @Inject
    DataManager mDataManager;

    private NetworkComponent mNetworkComponent;
    private ApplicationComponent mApplicationComponent;
    private static Application instance;

    public static Application getInstance() {
        if (instance == null)
            instance = new Application();

        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // Initialize the SDK before executing any other operations,
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mNetworkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule()).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }

    // Needed to replace the component with a test specific one
    public void setNetworkComponent(NetworkComponent networkComponent) {
        mNetworkComponent = networkComponent;
    }
}
