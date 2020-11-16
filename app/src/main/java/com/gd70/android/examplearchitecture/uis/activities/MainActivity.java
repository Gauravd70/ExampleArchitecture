package com.gd70.android.examplearchitecture.uis.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.gd70.android.examplearchitecture.R;
import com.gd70.android.examplearchitecture.uis.presenter_listeners.MainActivityPresenterListener;
import com.gd70.android.examplearchitecture.uis.presenters.MainActivityPresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainActivityPresenterListener {
    @BindView(R.id.text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().updateText();
    }

    @Override
    public MainActivityPresenter bindPresenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    public void setText(String text) {
        textView.setText(text);
    }
}