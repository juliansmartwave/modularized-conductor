package com.smartwave.test.genie.apps.ui.controller.main;

import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.ui.base.BasePresenter;
import com.smartwave.test.genie.apps.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by smartwave on 13/10/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>{

    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadSomething() {
        getDataManager().getApiHeader();
    }
}
