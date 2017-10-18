package com.smartwave.test.genie.apps;

import android.app.Application;

import com.smartwave.test.genie.apps.di.component.ApplicationComponent;
import com.smartwave.test.genie.apps.di.component.DaggerApplicationComponent;
import com.smartwave.test.genie.apps.di.module.ApplicationModule;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by smartwave on 13/10/2017.
 */

public class TestGenieAppsApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        initFonts();

    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    private void initFonts() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/App-Font-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
