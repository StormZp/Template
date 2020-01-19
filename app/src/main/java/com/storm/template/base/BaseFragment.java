package com.storm.template.base;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.SuperBaseViewModel;
import com.storm.mylibrary.base.SuperBaseFragment;

public abstract class BaseFragment<V extends ViewDataBinding, VM extends SuperBaseViewModel> extends SuperBaseFragment<V,VM> {
}
