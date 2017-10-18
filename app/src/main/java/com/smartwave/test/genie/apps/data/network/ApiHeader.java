package com.smartwave.test.genie.apps.data.network;


import com.smartwave.test.genie.apps.data.prefs.PreferencesHelper;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;


public class ApiHeader {

    private PreferencesHelper preferencesHelper;

    @Inject
    public ApiHeader(PreferencesHelper preferencesHelper) {
        this.preferencesHelper = preferencesHelper;
    }

    public Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("User-Agent", preferencesHelper.getUserAgent());

        return map;
    }

}
