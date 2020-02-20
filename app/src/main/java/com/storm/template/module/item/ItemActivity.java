package com.storm.template.module.item;

import android.os.Bundle;

import com.storm.template.databinding.ItemActivityBinding;
import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.base.BaseActivity;

public class ItemActivity extends BaseActivity<ItemActivityBinding, com.storm.template.module.item.ItemViewModel> {
    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.item_activity;
    }
}

