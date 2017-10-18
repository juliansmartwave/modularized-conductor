package com.smartwave.test.genie.apps.di.module;

import android.app.Application;
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
import com.smartwave.test.genie.apps.di.ApplicationContext;
import com.smartwave.test.genie.apps.di.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by smartwave on 13/10/2017.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(Preferences preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApi apiHelper) {
        return apiHelper;
    }

    @Provides
    @Singleton
    AuthHelper provideAuthHelper(Auth auth){
        return auth;
    }

    @Provides
    @Singleton
    ApiHeader provideApiHeader(PreferencesHelper preferencesHelper) {
        return new ApiHeader(preferencesHelper);
    }


}
