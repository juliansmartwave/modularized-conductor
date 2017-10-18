package com.smartwave.test.genie.apps.ui.controller.login;

import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.ui.base.BasePresenter;
import com.smartwave.test.genie.apps.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by smartwave on 17/10/2017.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V>{

    @Inject
    public LoginPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
