package com.smartwave.test.genie.apps.di.component;

import android.app.Application;
import android.content.Context;

import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.di.ApplicationContext;
import com.smartwave.test.genie.apps.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by smartwave on 13/10/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(Application application);

    @ApplicationContext
    Context getContext();

    DataManager getDataManager();

}
