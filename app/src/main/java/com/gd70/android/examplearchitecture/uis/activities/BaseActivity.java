package com.gd70.android.examplearchitecture.uis.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.gd70.android.examplearchitecture.uis.presenter_listeners.BasePresenterListener;
import com.gd70.android.examplearchitecture.uis.presenters.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<Presenter extends BasePresenter> extends Activity implements BasePresenterListener {
    private Presenter presenter;
    private Unbinder activityUnBinder;
    private Unbinder presenterUnBinder;

    public abstract Presenter bindPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter==null)
            presenter=bindPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        if(activityUnBinder!=null)
        {
            activityUnBinder.unbind();
            activityUnBinder=null;
        }
        if(presenterUnBinder!=null)
        {
            presenterUnBinder.unbind();
            presenterUnBinder=null;
        }

        activityUnBinder= ButterKnife.bind(this);
        if(presenterUnBinder!=null)
            presenterUnBinder=ButterKnife.bind(presenter,this);
    }

    @Override
    public void showToast(String toast) {
        Toast.makeText(getContext(),toast,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String toast, int duration) {
        Toast.makeText(getContext(),toast,duration).show();
    }

    @Override
    public void close() {
        finishAffinity();
    }

    protected Presenter getPresenter() {
        return presenter;
    }
}
