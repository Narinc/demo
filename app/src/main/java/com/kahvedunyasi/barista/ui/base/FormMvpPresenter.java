package com.kahvedunyasi.barista.ui.base;

import android.support.annotation.StringRes;
import android.widget.EditText;


public interface FormMvpPresenter<V extends FormMvpView> extends MvpPresenter<V>{
    boolean showErrorOnEditText(EditText editText, boolean error, String errorStr);

    boolean isEmptyEditText(EditText editText, @StringRes int resId);

    boolean hasMaxLengthEditText(EditText editText, @StringRes int resId, int maxLength);

    boolean hasMinLengthEditText(EditText editText, @StringRes int resId, int minLength);

    boolean isEmailValid(EditText editText, int resId);

    boolean validateEmail(EditText editText, @StringRes int resId);
}
