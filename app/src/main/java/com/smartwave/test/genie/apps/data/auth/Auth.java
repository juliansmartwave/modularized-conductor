package com.smartwave.test.genie.apps.data.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by smartwave on 13/10/2017.
 */

public class Auth implements AuthHelper {

    @Inject
    public Auth(){

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
}
