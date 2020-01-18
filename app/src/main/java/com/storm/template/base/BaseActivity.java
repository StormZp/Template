package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.BaseViewModel;
import com.storm.mylibrary.base.SuperBaseActivity;

public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseActivity<V,VM> {
}
