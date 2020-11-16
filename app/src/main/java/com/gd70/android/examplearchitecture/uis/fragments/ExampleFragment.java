package com.gd70.android.examplearchitecture.uis.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gd70.android.examplearchitecture.R;
import com.gd70.android.examplearchitecture.uis.presenter_listeners.MainActivityPresenterListener;
import com.gd70.android.examplearchitecture.uis.presenters.MainActivityPresenter;

public class ExampleFragment extends BaseFragment<MainActivityPresenter> implements MainActivityPresenterListener {

    public ExampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().updateText();
    }

    @Override
    public MainActivityPresenter bindPresenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    public void setText(String text) {
        //empty
    }
}