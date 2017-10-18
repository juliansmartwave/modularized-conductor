package com.smartwave.test.genie.apps.ui.controller.main;

import com.androidnetworking.error.ANError;
import com.smartwave.test.genie.apps.ui.base.MvpPresenter;
import com.smartwave.test.genie.apps.ui.base.MvpView;

/**
 * Created by smartwave on 13/10/2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V>{

    void loadSomething();
}
