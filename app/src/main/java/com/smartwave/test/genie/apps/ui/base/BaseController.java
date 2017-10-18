package com.smartwave.test.genie.apps.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smartwave.test.genie.apps.di.component.ControllerComponent;
import com.smartwave.test.genie.apps.di.component.DaggerControllerComponent;
import com.smartwave.test.genie.apps.di.module.ControllerModule;


public abstract class BaseController extends RefWatchingController implements MvpView {

    protected BaseActivity mActivity;

    private ControllerComponent mControllerComponent;

    protected BaseController() {
    }

    protected BaseController(Bundle args) {
        super(args);
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        setHasOptionsMenu(false);

        if (getActivity() instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) getActivity();
            this.mActivity = activity;
        }

        mControllerComponent = DaggerControllerComponent.builder()
                .controllerModule(new ControllerModule())
                .activityComponent(((BaseActivity) getActivity()).getActivityComponent())
                .build();
        return super.onCreateView(inflater, container);
    }

    @Override
    protected void onAttach(@NonNull View view) {
        super.onAttach(view);

    }

    public ControllerComponent getControllerComponent() {
        return mControllerComponent;
    }

    protected abstract void setUp(View view);

    @Override
    protected void onActivityResumed(@NonNull Activity activity) {
        super.onActivityResumed(activity);
        mActivity = (BaseActivity) activity;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void onError(String message) {

    }

    @Override
    public boolean isNetworkConnected() {

        return false;
    }

    @Override
    public void onDetach(View view) {
        mActivity = null;
        super.onDetach(view);
    }

    @Override
    public void showInvalidRoute() {
        if (mActivity != null) {
            Snackbar.make(mActivity.findViewById(android.R.id.content),"Invalid Route Point", Snackbar.LENGTH_SHORT).show();
        }
    }
}
