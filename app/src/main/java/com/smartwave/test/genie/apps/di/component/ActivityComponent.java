package com.smartwave.test.genie.apps.di.component;

import com.smartwave.test.genie.apps.MainActivity;
import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.di.PerActivity;
import com.smartwave.test.genie.apps.di.module.ActivityModule;
import com.smartwave.test.genie.apps.utils.rx.SchedulerProvider;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by smartwave on 13/10/2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    DataManager getDataManager();

    CompositeDisposable getCompositeDisposable();

    SchedulerProvider getSchedulerProvider();

}
