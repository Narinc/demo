package com.kahvedunyasi.barista.ui.base;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;


public interface MvpView<T> {

    void openLoggedInActivity();

    void openLogoutActivity();

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    Context getContext();

    void enableViews(View... views);

    void disableViews(View... views);

    //void setPresenter(T presenter);

}
