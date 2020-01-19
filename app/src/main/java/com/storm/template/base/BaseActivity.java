package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.SuperBaseActivity;
import com.storm.template.app.AppViewModelFactory;


public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseActivity<V, VM> {
    @Override
    protected void initData() {
        super.initData();
        mViewModel.setRepository(AppViewModelFactory.getInstance().getRepository());
    }
}
