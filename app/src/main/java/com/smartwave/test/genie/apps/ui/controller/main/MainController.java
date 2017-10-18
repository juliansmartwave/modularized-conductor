package com.smartwave.test.genie.apps.ui.controller.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.smartwave.test.genie.apps.R;
import com.smartwave.test.genie.apps.ui.base.BaseController;
import com.smartwave.test.genie.apps.utils.BundleBuilder;
import com.smartwave.test.genie.apps.utils.ControllerFactory;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by smartwave on 13/10/2017.
 */

public class MainController extends BaseController implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;


    public static MainController newInstance() {

        return new MainController(
                new BundleBuilder(new Bundle())
                        .build());
    }

    public MainController(Bundle args) {
        super(args);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_main,container,false);
        getControllerComponent().inject(this);
        mPresenter.onAttach(this);
        setUp(view);
        return view;
    }

    @OnClick(R.id.goToLoginBtn)
    void goToLogin(){
        GateKeeper.push(getRouter(),GateKeeper.Destination.LOGIN, new HorizontalChangeHandler(), new HorizontalChangeHandler());
    }

}
