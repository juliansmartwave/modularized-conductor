package com.smartwave.test.genie.apps;

import android.os.Bundle;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.smartwave.test.genie.apps.ui.base.BaseActivity;
import com.smartwave.test.genie.apps.utils.ControllerFactory;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


//TopBuy Test Activity
//configures different routes, router root.
//root here is DETAILS
public class MainActivity extends BaseActivity {


    @BindView(R.id.activity_main_frame)
    ViewGroup mContainer;

    Router mRouter;

    private List<GateKeeper.Destination> mDetailsRouteOrigins;
    private List<GateKeeper.Destination> mLoginRouteOrigins;
    private List<GateKeeper.Destination> mMainRouteOrigins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUnBinder(ButterKnife.bind(this));

        mRouter = Conductor.attachRouter(this, mContainer, savedInstanceState);

//        mDetailsRouteOrigins = new GateKeeper.RouteBuilder()
//                .addRouteFrom(GateKeeper.Destination.LOGIN)
//                .addRouteFrom(GateKeeper.Destination.CHECKOUT)
//                .build();

        //create route origins for main
        mMainRouteOrigins = new GateKeeper.RouteBuilder()
                .addRouteFrom(GateKeeper.Destination.LOGIN)
                .build();

        //create route origins for login
        mLoginRouteOrigins = new GateKeeper.RouteBuilder()
                .addRouteFrom(GateKeeper.Destination.DETAILS)
                .build();

        //register them
        GateKeeper.registerRoute(GateKeeper.Destination.LOGIN, mLoginRouteOrigins);
        GateKeeper.registerRoute(GateKeeper.Destination.MAIN, mMainRouteOrigins);

        //call to update CURRENT_LOCATION too
        //pag di mo pinadaan sa gatekeeper baka makalimutan ng developer to set CURRENT_LOCATION.
        GateKeeper.setRoot(mRouter,GateKeeper.Destination.DETAILS,
                RouterTransaction.with(ControllerFactory.getInstance(GateKeeper.Destination.DETAILS)));

    }

    @Override
    public void onBackPressed() {
        if(mRouter.getBackstackSize() == 1){
            finish();
        }else{
            mRouter.handleBack();
        }
    }
}
