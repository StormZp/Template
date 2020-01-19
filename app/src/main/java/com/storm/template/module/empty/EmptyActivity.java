package com.storm.template.module.empty;

import android.os.Bundle;

import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.databinding.EmptyActivityBinding;
import com.storm.template.base.BaseActivity;

public class EmptyActivity extends BaseActivity<EmptyActivityBinding, EmptyViewModel> {
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.empty_activity;
    }

}

