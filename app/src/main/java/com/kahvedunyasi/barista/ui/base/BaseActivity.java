package com.kahvedunyasi.barista.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.kahvedunyasi.barista.BaseApplication;
import com.kahvedunyasi.barista.di.component.ActivityComponent;
import com.kahvedunyasi.barista.di.component.DaggerActivityComponent;
import com.kahvedunyasi.barista.di.module.ActivityModule;
import com.kahvedunyasi.barista.providers.LoyaltyLocationProvider;
import com.kahvedunyasi.barista.ui.barista.BaristaActivity;
import com.kahvedunyasi.barista.util.CommonUtils;
import com.kahvedunyasi.barista.util.NetworkUtils;

import javax.inject.Inject;

import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity
        implements BaseFragment.Callback, MvpView {

    private ProgressDialog mProgressDialog;
    private ActivityComponent mActivityComponent;
    private Unbinder mUnBinder;
    private LoyaltyLocationProvider locationProvider;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 7172;

    @Inject
    BasePresenter<MvpView> mPresenter;

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(permissions, requestCode);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void enableViews(View... views) {
        for (View v : views) {
            v.setEnabled(true);
        }
    }

    @Override
    public void disableViews(View... views) {
        for (View v : views) {
            v.setEnabled(false);
        }
    }

    @Override
    public void openLoggedInActivity() {
        BaristaActivity.newIntent(this);
        finish();
    }

    @Override
    public void openLogoutActivity() {
       /* Class logoutActivity = SplashScreenActivity.class;
        if (this instanceof SplashScreenActivity)
            logoutActivity = OnboardingScreenActivity.class;

        Intent i = new Intent(this, logoutActivity);
        startActivity(i);

        // close splash activity
        finish();*/
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .networkComponent(((BaseApplication) getApplication()).getNetworkComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    private void showSnackBar(@StringRes int textResId) {
        showSnackBar(getString(textResId));
    }

    private void showSnackBar(String message) {
        showSnackBar(message, -1, null);
    }

    private void showSnackBar(String message, @StringRes int actionTextRestId, @Nullable View.OnClickListener actionClickListener) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        if (actionTextRestId != -1 && actionClickListener != null)
            snackbar.setAction(actionTextRestId, actionClickListener);
        snackbar.show();
    }

    @Override
    public void onError(String message) {
        if (message != null) showSnackBar(message);
    }

    @Override
    public void onError(@StringRes int resId) {
        showSnackBar(resId);
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
