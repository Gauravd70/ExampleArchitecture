package com.gd70.android.examplearchitecture.uis.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gd70.android.examplearchitecture.uis.presenter_listeners.BasePresenterListener;
import com.gd70.android.examplearchitecture.uis.presenters.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements BasePresenterListener {
    private Presenter presenter;
    private Unbinder fragmentUnBinder;
    private Unbinder presenterUnBinder;

    public abstract Presenter bindPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter==null)
            presenter=bindPresenter();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(fragmentUnBinder!=null)
        {
            fragmentUnBinder.unbind();
            fragmentUnBinder=null;
        }
        if(presenterUnBinder!=null)
        {
            presenterUnBinder.unbind();
            presenterUnBinder=null;
        }

        fragmentUnBinder = ButterKnife.bind(this, view);
        if (presenter != null)
            presenterUnBinder = ButterKnife.bind(presenter, view);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
        Activity activity=getActivity();
        if(activity!=null)
            activity.finishAffinity();
    }

    protected Presenter getPresenter() {
        return presenter;
    }
}
