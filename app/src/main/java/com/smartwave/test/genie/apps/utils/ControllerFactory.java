package com.smartwave.test.genie.apps.utils;

import android.os.Bundle;

import com.bluelinelabs.conductor.Controller;
import com.smartwave.test.genie.apps.ui.controller.details.DetailsController;
import com.smartwave.test.genie.apps.ui.controller.login.LoginController;
import com.smartwave.test.genie.apps.ui.controller.main.MainController;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import static com.smartwave.test.genie.apps.utils.GateKeeper.Destination.MAIN;

/**
 * Created by smartwave on 16/10/2017.
 */

//register here controllers and how to create instances of them
public class ControllerFactory {
    public static Controller getInstance(GateKeeper.Destination destination) {
        return getInstance(destination, new Bundle());
    }

    public static Controller getInstance(GateKeeper.Destination destination, Bundle bundle) {
        return determineConstructionType(destination, bundle);
    }

    private static Controller determineConstructionType(GateKeeper.Destination destination, Bundle bundle) {
        return bundle == null || bundle.isEmpty() ? simpleConstruction(destination) : buildWithParameters(destination,bundle);
    }

    private static Controller simpleConstruction(GateKeeper.Destination destination) {
        switch (destination) {
            case MAIN:
                return MainController.newInstance();
            case DETAILS:
                return DetailsController.newInstance();
            case LOGIN:
                return LoginController.newInstance();
            default:
                return null;
        }
    }

    private static Controller buildWithParameters(GateKeeper.Destination destination, Bundle bundle){
        switch (destination) {
            case MAIN:
                return new MainController(bundle);
            case DETAILS:
                return new DetailsController(bundle);
            case LOGIN:
                return new LoginController(bundle);
            default:
                return null;
        }
    }
}
