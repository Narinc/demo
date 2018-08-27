package com.kahvedunyasi.barista.ui.barista.login;

import android.os.Bundle;
import android.widget.EditText;

import com.kahvedunyasi.barista.R;
import com.kahvedunyasi.barista.ui.barista.BaristaActivity;
import com.kahvedunyasi.barista.ui.barista.login.presenter.LoginMvpPresenter;
import com.kahvedunyasi.barista.ui.barista.login.view.LoginView;
import com.kahvedunyasi.barista.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginMvpPresenter<LoginView> presenter;

    @BindView(R.id.email_edit)
    EditText emailEdit;
    @BindView(R.id.password_edit)
    EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.login_submit_button)
    void login() {
        /*String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();
        if (password.length() > 6 && email.length() > 1) {
            presenter.attemptLogin(email,password);
        }*/
        BaristaActivity.newIntent(getContext());
    }
}
