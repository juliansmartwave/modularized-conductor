package com.smartwave.test.genie.apps.ui.controller.details;

import com.smartwave.test.genie.apps.data.DataManager;
import com.smartwave.test.genie.apps.ui.base.BasePresenter;
import com.smartwave.test.genie.apps.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by smartwave on 16/10/2017.
 */

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V> implements DetailsMvpPresenter<V> {

    @Inject
    public DetailsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadDetails() {

    }
}
