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
//root here is MAIN
public class MainActivity extends BaseActivity {


    @BindView(R.id.activity_main_frame)
    ViewGroup mContainer;

    Router mRouter;

    private List<GateKeeper.Destination> mDetailsRouteOrigins;
    private List<GateKeeper.Destination> mLoginRouteOrigins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUnBinder(ButterKnife.bind(this));

        mRouter = Conductor.attachRouter(this, mContainer, savedInstanceState);

        mDetailsRouteOrigins = new GateKeeper.RouteBuilder()
                .addRouteFrom(GateKeeper.Destination.LOGIN)
                .build();

        mLoginRouteOrigins = new GateKeeper.RouteBuilder()
                .addRouteFrom(GateKeeper.Destination.MAIN)
                .build();

        GateKeeper.registerRoute(GateKeeper.Destination.DETAILS, mDetailsRouteOrigins);
        GateKeeper.registerRoute(GateKeeper.Destination.LOGIN, mLoginRouteOrigins);

        GateKeeper.setRoot(mRouter,GateKeeper.Destination.MAIN,
                RouterTransaction.with(ControllerFactory.getInstance(GateKeeper.Destination.MAIN)));

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
