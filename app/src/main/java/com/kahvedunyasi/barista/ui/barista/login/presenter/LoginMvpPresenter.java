package com.kahvedunyasi.barista.ui.barista.login.presenter;

import com.kahvedunyasi.barista.di.scope.PerActivity;
import com.kahvedunyasi.barista.ui.barista.login.view.LoginView;
import com.kahvedunyasi.barista.ui.base.MvpPresenter;

/**
 * Created by kuka on 30.07.2018.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginView> extends MvpPresenter<V> {

    void attemptLogin(String email, String password);
}
