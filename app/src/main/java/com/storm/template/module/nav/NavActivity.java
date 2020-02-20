package com.storm.template.module.nav;

import android.os.Bundle;

import com.storm.template.R;
import com.storm.template.base.BaseActivity;
import com.storm.template.databinding.NavActivityBinding;

public class NavActivity extends BaseActivity<NavActivityBinding, NavViewModel > {
    @Override
    public int initVariableId() {
        return com.storm.template.BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.nav_activity;
    }


}
