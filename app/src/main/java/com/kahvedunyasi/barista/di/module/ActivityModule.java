package com.kahvedunyasi.barista.di.module;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.kahvedunyasi.barista.data.network.request.post.RegisterRequestModel;
import com.kahvedunyasi.barista.di.scope.ActivityContext;
import com.kahvedunyasi.barista.di.scope.PerActivity;
import com.kahvedunyasi.barista.ui.barista.all_list.presenter.AllListMvpPresenter;
import com.kahvedunyasi.barista.ui.barista.all_list.presenter.AllListPresenter;
import com.kahvedunyasi.barista.ui.barista.all_list.view.AllListMvpView;
import com.kahvedunyasi.barista.ui.barista.login.presenter.LoginMvpPresenter;
import com.kahvedunyasi.barista.ui.barista.login.presenter.LoginPresenter;
import com.kahvedunyasi.barista.ui.barista.login.view.LoginView;
import com.kahvedunyasi.barista.ui.base.BasePresenter;
import com.kahvedunyasi.barista.ui.base.MvpPresenter;
import com.kahvedunyasi.barista.ui.base.MvpView;
import com.kahvedunyasi.barista.util.rx.AppSchedulerProvider;
import com.kahvedunyasi.barista.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(AppCompatActivity activity, int numOfColumns) {
        return new GridLayoutManager(activity, numOfColumns);
    }

    @Provides
    @PerActivity
    MvpPresenter<MvpView> provideBasePresenter(
            BasePresenter<MvpView> presenter) {
        return presenter;
    }

    //barista
    @Provides
    @PerActivity
    AllListMvpPresenter<AllListMvpView> porvideAllListPresenter(AllListPresenter<AllListMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginView> porvideLoginPresenter(LoginPresenter<LoginView> presenter) {
        return presenter;
    }

    //loyalty
    @Provides
    RegisterRequestModel provideRegisterRequestModel() {
        return new RegisterRequestModel();
    }

    @Provides
    Intent provideIntent() {
        return new Intent();
    }
}
