package com.smartwave.test.genie.apps.di.module;

import com.smartwave.test.genie.apps.ui.controller.details.DetailsMvpPresenter;
import com.smartwave.test.genie.apps.ui.controller.details.DetailsMvpView;
import com.smartwave.test.genie.apps.ui.controller.details.DetailsPresenter;
import com.smartwave.test.genie.apps.ui.controller.login.LoginMvpPresenter;
import com.smartwave.test.genie.apps.ui.controller.login.LoginMvpView;
import com.smartwave.test.genie.apps.ui.controller.login.LoginPresenter;
import com.smartwave.test.genie.apps.ui.controller.main.MainMvpPresenter;
import com.smartwave.test.genie.apps.ui.controller.main.MainMvpView;
import com.smartwave.test.genie.apps.ui.controller.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartwave on 13/10/2017.
 */
@Module
public class ControllerModule {

    @Provides
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    DetailsMvpPresenter<DetailsMvpView> provideDetailsPresenter(DetailsPresenter<DetailsMvpView> presenter){
        return presenter;
    }
}
