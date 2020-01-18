package com.storm.template.module.test;

import android.os.Bundle;

import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.base.BaseActivity;
import com.storm.template.databinding.TestActivityBinding;

public class TestActivity extends BaseActivity<TestActivityBinding, TestViewModel> {
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.test_activity;
    }
}

