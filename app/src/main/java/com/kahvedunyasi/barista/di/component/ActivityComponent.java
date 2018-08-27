package com.kahvedunyasi.barista.di.component;

import com.kahvedunyasi.barista.di.module.ActivityModule;
import com.kahvedunyasi.barista.di.scope.PerActivity;
import com.kahvedunyasi.barista.ui.barista.BaristaActivity;
import com.kahvedunyasi.barista.ui.barista.all_list.ProductListFragment;
import com.kahvedunyasi.barista.ui.barista.login.LoginActivity;
import com.kahvedunyasi.barista.ui.base.BaseActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = {ApplicationComponent.class, NetworkComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    //barista
    void inject(BaristaActivity activity);

    void inject(ProductListFragment fragment);

    void inject(LoginActivity activity);

    //loyalty

    void inject(BaseActivity activity);
}
