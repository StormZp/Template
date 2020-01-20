package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.SuperBaseFragment;
import com.storm.template.app.AppViewModelFactory;

public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseFragment<V,VM> {
    @Override
    protected void initData() {
        super.initData();
        mViewModel.setRepository(AppViewModelFactory.getInstance().getRepository());
    }
}
