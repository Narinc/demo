package com.kahvedunyasi.barista.ui.base;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.EditText;

import com.kahvedunyasi.barista.R;
import com.kahvedunyasi.barista.data.DataManager;
import com.kahvedunyasi.barista.di.component.NetworkComponent;
import com.kahvedunyasi.barista.util.AppConstants;
import com.kahvedunyasi.barista.util.CommonUtils;
import com.kahvedunyasi.barista.util.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseFormPresenter<V extends FormMvpView> extends BasePresenter<V> implements FormMvpPresenter<V> {
    public BaseFormPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, NetworkComponent networkComponent) {
        super(dataManager, schedulerProvider, compositeDisposable, networkComponent);
    }

    @Override
    public boolean showErrorOnEditText(EditText editText, boolean error, String errorStr) {
        if (error) {
            editText.setError(errorStr);
            editText.requestFocus();
//TODO: If you want show just icon next on the field
//            nameEditText.setError("")
// TODO: If you want show snack
//            onError(errorStr);

        }
        return error;
    }

    @Override
    public boolean isEmptyEditText(EditText editText, @StringRes int resId) {
        return showErrorOnEditText(
                editText,
                editText.getText().toString().isEmpty(),
                getString(R.string.empty_warning, getString(resId)));
    }

    @NonNull
    protected String getString(@StringRes int resId, String string) {
        return getMvpView().getContext().getString(resId, string);
    }

    @NonNull
    protected String getString(@StringRes int resId) {
        return getMvpView().getContext().getString(resId);
    }

    @Override
    public boolean hasMaxLengthEditText(EditText editText, @StringRes int resId, int maxLength) {
        String warningMessage = getString(R.string.max_length_warning);
        String firstText = getString(resId);
        int editTextLength = editText.getText().toString().length();
        return showErrorOnEditText(
                editText,
                editTextLength > maxLength,
                String.format(warningMessage, firstText, String.valueOf(maxLength))
        );
    }

    @Override
    public boolean hasMinLengthEditText(EditText editText, @StringRes int resId, int minLength) {
        String warningMessage = getString(R.string.min_length_warning);
        String firstText = getString(resId);
        int editTextLength = editText.getText().toString().length();

        return showErrorOnEditText(
                editText,
                editTextLength < minLength,
                String.format(warningMessage, firstText, String.valueOf(minLength))
        );
    }

    @Override
    public boolean isEmailValid(EditText editText, int resId) {
        return showErrorOnEditText(
                editText,
                !CommonUtils.isEmailValid(editText.getText().toString()),
                getString(R.string.not_valid_email));
    }


    @Override
    public boolean validateEmail(EditText editText, @StringRes int resId) {
        boolean error;

        error = isEmptyEditText(editText, resId);

        if (!error)
            error = hasMaxLengthEditText(editText, resId, AppConstants.MAX_EMAIL_LENGTH);

        if (!error)
            error = hasMinLengthEditText(editText, resId, AppConstants.MIN_EMAIL_LENGTH);

        if (!error)
            error = isEmailValid(editText, resId);

        return !error;
    }

}
