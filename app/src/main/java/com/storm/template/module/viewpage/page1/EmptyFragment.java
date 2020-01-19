package com.storm.template.module.viewpage.page1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;

import androidx.annotation.Nullable;

import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.app.AppViewModelFactory;
import com.storm.template.base.BaseFragment;
import com.storm.template.databinding.PageFragmentEmptyBinding;

public class EmptyFragment extends BaseFragment<PageFragmentEmptyBinding,ViewPagerEmptyViewModel> {

    private final String title;

    public EmptyFragment(String title){
        this.title = title;
    }
    @Override
    public int initVariableId() {
        return com.storm.template.BR.viewModel;
    }

//    @Override
//    protected ViewPagerEmptyViewModel initViewModel() {
//        return AppViewModelFactory.getInstance().create(ViewPagerEmptyViewModel.class);
//    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.page_fragment_empty;
    }

    @Override
    protected void initData() {
        mBinding.getViewModel().title.set(title);
    }
}
