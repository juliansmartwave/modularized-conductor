package com.smartwave.test.genie.apps.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by smartwave on 13/10/2017.
 */

public class AppApi implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApi(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

}
