package com.smartwave.test.genie.apps.ui.controller.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler;
import com.smartwave.test.genie.apps.BuildConfig;
import com.smartwave.test.genie.apps.R;
import com.smartwave.test.genie.apps.ui.base.BaseController;
import com.smartwave.test.genie.apps.utils.BundleBuilder;
import com.smartwave.test.genie.apps.utils.GateKeeper;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by smartwave on 17/10/2017.
 */

public class LoginController extends BaseController implements LoginMvpView {

    @Inject
    LoginMvpPresenter<LoginMvpView> mPresenter;

    public static LoginController newInstance() {
        return new LoginController(
                new BundleBuilder(new Bundle())
                        .build());
    }

    public LoginController(Bundle args) {
        super(args);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.controller_login,container,false);
        getControllerComponent().inject(this);
        mPresenter.onAttach(this);
        setUp(view);
        return view;
    }

    @OnClick(R.id.login_button)
    void loginBtnPressed() {
        GateKeeper.push(getRouter(), GateKeeper.Destination.DETAILS
                , new HorizontalChangeHandler(), new HorizontalChangeHandler());

    }
}
