package com.smartwave.test.genie.apps.di.component;

import com.smartwave.test.genie.apps.di.PerController;
import com.smartwave.test.genie.apps.di.module.ControllerModule;
import com.smartwave.test.genie.apps.ui.controller.details.DetailsController;
import com.smartwave.test.genie.apps.ui.controller.login.LoginController;
import com.smartwave.test.genie.apps.ui.controller.main.MainController;

import dagger.Component;

/**
 * Created by smartwave on 13/10/2017.
 */
@PerController
@Component(dependencies = ActivityComponent.class, modules = ControllerModule.class)
public interface ControllerComponent {

    void inject (MainController controller);

    void inject (LoginController controller);

    void inject (DetailsController controller);
}
