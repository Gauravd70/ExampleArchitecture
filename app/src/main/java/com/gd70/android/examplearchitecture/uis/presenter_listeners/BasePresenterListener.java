package com.gd70.android.examplearchitecture.uis.presenter_listeners;

import android.app.Activity;
import android.content.Context;

public interface BasePresenterListener {
    Activity getActivity();
    Context getContext();
    void showToast(String toast);
    void showToast(String toast,int duration);
    void close();
}
