package com.storm.template.module.nav.test2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.storm.template.R;
import com.storm.template.base.BaseFragment;
import com.storm.template.databinding.NavFragmentTest2Binding;

public class NavTest2Fragment extends BaseFragment<NavFragmentTest2Binding, NavTest2ViewModel> {


    @Override
    public int initVariableId() {
        return com.storm.template.BR.viewModel;
    }

//    @Override
//    protected NavTest2ViewModel initViewModel() {
//        return AppViewModelFactory.getInstance().create(NavTest2ViewModel.class);
//    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.nav_fragment_test2;
    }

}
