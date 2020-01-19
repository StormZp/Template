package com.storm.template.module.viewpage;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.storm.mylibrary.adapter.FragmentAdapter;
import com.storm.template.BR;
import com.storm.template.R;
import com.storm.template.base.BaseActivity;
import com.storm.template.databinding.ViewpageActivityBinding;
import com.storm.template.module.viewpage.page1.EmptyFragment;

import java.util.ArrayList;

public class ViewPagerActivityActivity extends BaseActivity<ViewpageActivityBinding, ViewPagerActivityViewModel> {
    private ArrayList<Fragment> fragments;

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    protected int initContentView(Bundle savedInstanceState) {
        return R.layout.viewpage_activity;
    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.bottom.inflateMenu(R.menu.page_menu);
        mBinding.bottom.setItemIconTintList(null);


        mBinding.bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getTitle().toString()) {
                    case "page1": {
                        mBinding.viewpager.setCurrentItem(0, false);
                    }
                    break;
                    case "page2": {
                        mBinding.viewpager.setCurrentItem(1, false);
                    }
                    break;
                    case "page3": {
                        mBinding.viewpager.setCurrentItem(2);
                    }
                    break;
                    case "page4": {
                        mBinding.viewpager.setCurrentItem(3);
                    }
                    break;


                }
                return true;
            }
        });

                fragments = new ArrayList<>();
                fragments.add(new EmptyFragment("页面一"));
                fragments.add(new EmptyFragment("页面二"));
                fragments.add(new EmptyFragment("页面三"));
                fragments.add(new EmptyFragment("页面四"));
                mBinding.viewpager.setAdapter(new FragmentAdapter(this.getSupportFragmentManager(), this, fragments));
                mBinding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

