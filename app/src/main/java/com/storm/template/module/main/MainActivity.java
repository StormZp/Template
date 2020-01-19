package com.storm.template.module.main;

import android.os.Bundle;

import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.databinding.MainActivityBinding;
import com.storm.template.base.BaseActivity;

public class MainActivity extends BaseActivity<MainActivityBinding, MainViewModel> {
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.main_activity;
    }

}

