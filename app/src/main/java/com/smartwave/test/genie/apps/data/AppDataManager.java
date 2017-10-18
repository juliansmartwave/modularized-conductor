package com.smartwave.test.genie.apps.data;

import android.content.Context;
import android.util.Log;

import com.smartwave.test.genie.apps.data.auth.AuthHelper;
import com.smartwave.test.genie.apps.data.network.ApiHeader;
import com.smartwave.test.genie.apps.data.network.ApiHelper;
import com.smartwave.test.genie.apps.data.prefs.PreferencesHelper;
import com.smartwave.test.genie.apps.di.ActivityContext;
import com.smartwave.test.genie.apps.di.ApplicationContext;


import javax.inject.Inject;
import javax.inject.Singleton;


public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private final AuthHelper mAuthHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper,
                          AuthHelper authHelper) {
        mContext = context;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mAuthHelper = authHelper;
    }

    @Override
    public void acknowledgeAuth(String loginTicket) {

    }

    @Override
    public void revokeAuth() {

    }

    @Override
    public void setLoginTicket(String loginTicket) {

    }

    @Override
    public String getLoginTicket() {
        return null;
    }

    @Override
    public boolean isAuthorized() {
        return false;
    }

    @Override
    public String getUserAgent() {
        return null;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }
}
