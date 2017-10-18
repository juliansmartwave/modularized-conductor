package com.smartwave.test.genie.apps.data.prefs;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by smartwave on 13/10/2017.
 */
public class Preferences implements PreferencesHelper {

    @Inject
    public Preferences(){

    }

    @Override
    public String getUserAgent() {
        return null;
    }
}
