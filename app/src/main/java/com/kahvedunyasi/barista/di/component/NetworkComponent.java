package com.kahvedunyasi.barista.di.component;

import com.kahvedunyasi.barista.data.network.service.RobotposService;
import com.kahvedunyasi.barista.di.module.NetworkModule;

import dagger.Component;


@Component(modules = NetworkModule.class)
public interface NetworkComponent {
    //barista
    //LoginService getLoginService();
    RobotposService getRobotposService();
}
