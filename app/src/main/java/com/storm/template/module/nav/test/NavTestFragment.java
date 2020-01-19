package com.storm.template.module.nav.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.base.BaseFragment;
import com.storm.template.databinding.NavFragmentTestBinding;

public class NavTestFragment extends BaseFragment<NavFragmentTestBinding, NavTestViewModel> {


    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

//    @Override
//    protected NavTestViewModel initViewModel() {
//        return AppViewModelFactory.getInstance().create(NavTestViewModel.class);
//    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.nav_fragment_test;
    }

}
