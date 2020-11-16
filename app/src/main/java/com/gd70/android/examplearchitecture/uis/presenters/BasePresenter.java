package com.gd70.android.examplearchitecture.uis.presenters;

import com.gd70.android.examplearchitecture.uis.presenter_listeners.BasePresenterListener;

public abstract class BasePresenter<PresenterListener extends BasePresenterListener> {
    private PresenterListener presenterListener;

    public BasePresenter(PresenterListener presenterListener) {
        this.presenterListener = presenterListener;
    }

    protected PresenterListener getPresenterListener() {
        return presenterListener;
    }
}
