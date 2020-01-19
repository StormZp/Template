package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.BaseViewModel;
import com.storm.mylibrary.base.SuperBaseFragment;

public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseFragment<V,VM> {
}
