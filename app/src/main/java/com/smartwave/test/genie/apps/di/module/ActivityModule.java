package com.smartwave.test.genie.apps.di.module;

import android.app.Activity;
import android.content.Context;

import com.smartwave.test.genie.apps.data.AppDataManager;
import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.data.auth.Auth;
import com.smartwave.test.genie.apps.data.auth.AuthHelper;
import com.smartwave.test.genie.apps.data.network.ApiHeader;
import com.smartwave.test.genie.apps.data.network.ApiHelper;
import com.smartwave.test.genie.apps.data.network.AppApi;
import com.smartwave.test.genie.apps.data.prefs.Preferences;
import com.smartwave.test.genie.apps.data.prefs.PreferencesHelper;
import com.smartwave.test.genie.apps.di.ActivityContext;
import com.smartwave.test.genie.apps.di.PerActivity;
import com.smartwave.test.genie.apps.utils.rx.AppSchedulerProvider;
import com.smartwave.test.genie.apps.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by smartwave on 13/10/2017.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }



}
