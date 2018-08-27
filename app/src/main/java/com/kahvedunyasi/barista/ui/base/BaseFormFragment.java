package com.kahvedunyasi.barista.ui.base;

import android.view.View;


public abstract class BaseFormFragment extends BaseFragment {

    public abstract boolean validate();

    protected abstract void setUp(View view);

}
