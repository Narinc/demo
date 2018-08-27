package com.kahvedunyasi.barista.ui.barista.login.presenter;

import android.util.Log;

import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.di.component.NetworkComponent;
import com.kahvedunyasi.barista.ui.barista.login.view.LoginView;
import com.kahvedunyasi.barista.ui.base.BasePresenter;
import com.kahvedunyasi.barista.util.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by kuka on 30.07.2018.
 */

public class LoginPresenter<V extends LoginView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, NetworkComponent networkComponent) {
        super(dataManager, schedulerProvider, compositeDisposable, networkComponent);
    }

    @Override
    public void attemptLogin(final String email, String password) {
        /*
        getMvpView().showLoading();
        getNetworkComponent().getLoginService().getLogin(email, password, new LoginService.LoginServiceCallback<BaseResponseModel<LoginResponseModel>>() {
            @Override
            public void onSuccess(BaseResponseModel<LoginResponseModel> response) {
                getMvpView().hideLoading();
                getDataManager().setCurrentUserId(response.getData().getUserId());
                getDataManager().setCurrentUserName(response.getData().getUserId());
                getDataManager().setCurrentUserEmail(email);
                getDataManager().setCurrentUserAccessToken(response.getData().getAccessToken());

                Log.i("AccessTokenService", response.getData().getAccessToken());
                Log.i("AccessToken", getDataManager().getCurrentUserAccessToken());

                getDataManager().setCurrentUserLoggedInMode(DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_IN);
                loggedIn();
                getMvpView().hideLoading();
            }

            @Override
            public void onError(String error) {
                getMvpView().hideLoading();
                getMvpView().onError(error);
            }
        });*/
    }
}
