package com.smartwave.test.genie.apps.ui.controller.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.smartwave.test.genie.apps.R;
import com.smartwave.test.genie.apps.ui.base.BaseController;
import com.smartwave.test.genie.apps.ui.controller.main.MainController;
import com.smartwave.test.genie.apps.utils.BundleBuilder;
import com.smartwave.test.genie.apps.utils.ControllerFactory;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by smartwave on 16/10/2017.
 */

public class DetailsController extends BaseController implements DetailsMvpView {

    @Inject
    DetailsMvpPresenter<DetailsMvpView> mPresenter;

    public static DetailsController newInstance() {
        return new DetailsController(
                new BundleBuilder(new Bundle())
                        .build());
    }

    public DetailsController(Bundle args) {
        super(args);
    }


    @Override
    protected void setUp(View view) {

    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_details,container,false);
        getControllerComponent().inject(this);
        mPresenter.onAttach(this);
        setUp(view);
        return view;
    }

    @OnClick(R.id.applyBtn)
    void doSomething(){
        GateKeeper.push(getRouter(), GateKeeper.Destination.LOGIN,new HorizontalChangeHandler(),new HorizontalChangeHandler());
    }
}
