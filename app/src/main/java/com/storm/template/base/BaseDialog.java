package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.SuperBaseDialog;
import com.storm.template.app.AppViewModelFactory;

public abstract class BaseDialog<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseDialog<V, VM> {
    @Override
    protected void initData() {
        super.initData();
        mViewModel.setRepository(AppViewModelFactory.getInstance().getRepository());
    }
}
