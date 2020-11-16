package com.gd70.android.examplearchitecture.uis.presenters;

import com.gd70.android.examplearchitecture.uis.presenter_listeners.MainActivityPresenterListener;

import static com.gd70.android.examplearchitecture.utils.Constants.BASE_URL;

public class MainActivityPresenter extends BasePresenter<MainActivityPresenterListener> {

    public MainActivityPresenter(MainActivityPresenterListener presenterListener) {
        super(presenterListener);
    }

    public void updateText(){
        getPresenterListener().setText(BASE_URL);
        getPresenterListener().showToast("Example toast");
    }
}
