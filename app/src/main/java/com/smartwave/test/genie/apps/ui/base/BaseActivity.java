package com.smartwave.test.genie.apps.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.smartwave.test.genie.apps.TestGenieAppsApplication;
import com.smartwave.test.genie.apps.di.component.ActivityComponent;
import com.smartwave.test.genie.apps.di.component.DaggerActivityComponent;
import com.smartwave.test.genie.apps.di.module.ActivityModule;

import butterknife.Unbinder;

/**
 * Created by smartwave on 13/10/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    private ActivityComponent mActivityComponent;

    private Unbinder mUnBinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((TestGenieAppsApplication)getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this)).build();

    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }


}
