package com.smartwave.test.genie.apps.utils;


import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.smartwave.test.genie.apps.R;
import com.smartwave.test.genie.apps.di.ApplicationContext;
import com.smartwave.test.genie.apps.ui.base.BaseController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by smartwave on 16/10/2017.
 */

public class GateKeeper {

    public static Destination CURRENT_LOCATION;

    public enum Destination {
        SPLASH,
        LOGIN,
        DETAILS,
        MAIN,
        REGISTER,
        SALEITEMS,
        CHECKOUT
        //add more destinations
    }

    private static HashMap<Destination,List<Destination>> mRouteMap = new HashMap<>();

    public static void registerRoute(Destination destination, List<Destination> routesFrom){
        mRouteMap.put(destination,routesFrom);
    }


//    static LinkedHashMap<Destination,LinkedList<Destination>> mRouteListTree = new LinkedHashMap<>();
//    static HashMap<Router, LinkedHashMap<Destination,LinkedList<Destination>>> mRouterMappping = new HashMap<>();

    public static class RouteBuilder {
        private List<Destination> mRouteList = new ArrayList<>();

        public RouteBuilder addRouteFrom(Destination destination) {
            mRouteList.add(destination);
            return this;
        }

        public List<Destination> build() {
            return mRouteList;
        }
    }


    private static boolean validateRouteOrigin(Destination destination){
        List<Destination> validOrigins = mRouteMap.get(destination);

        if(validOrigins == null || !validOrigins.contains(CURRENT_LOCATION)){
            //throw RouteNotValidException
            return false;
        }

        return true;
    }

    //will check if valid route
    //default push/pop changehandler
    public static void push (Router router, Destination destination, ControllerChangeHandler pushChangeHandler, ControllerChangeHandler popChangeHandler){
        if(validateRouteOrigin(destination)){
            router.pushController(RouterTransaction.with(ControllerFactory.getInstance(destination)).pushChangeHandler(pushChangeHandler).popChangeHandler(popChangeHandler));
            CURRENT_LOCATION = destination;
        } else {
            Controller currentController = getCurrentControllerOnRouter(router);
            if(currentController != null) {
                ((BaseController) currentController).showInvalidRoute();
            }
        }
    }

    public static Controller getCurrentControllerOnRouter(Router router) {
        int topIndex = router.getBackstackSize() - 1;
        if (topIndex >= 0) {
            return router.getBackstack().get(topIndex).controller();
        }

        return null;
    }

    public static void push(Router router, Destination destination){
        push(router,destination,null,null);
    }

    public static void setRoot(Router router, Destination destination, RouterTransaction routerTransaction){
        router.setRoot(routerTransaction);
        CURRENT_LOCATION = destination;
    }

}
