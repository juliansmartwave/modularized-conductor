package com.smartwave.test.genie.apps.ui.controller.details;

import com.smartwave.test.genie.apps.ui.base.MvpPresenter;

/**
 * Created by smartwave on 16/10/2017.
 */

public interface DetailsMvpPresenter<V extends DetailsMvpView> extends MvpPresenter<V> {
    void loadDetails();
}
