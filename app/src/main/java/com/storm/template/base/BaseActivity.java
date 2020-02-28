package com.storm.template.base;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.ViewDataBinding;

import com.storm.mylibrary.base.SuperBaseActivity;
import com.storm.template.R;
import com.storm.template.app.AppViewModelFactory;


public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends SuperBaseActivity<V, VM> {
    @Override
    protected void initData() {
        super.initData();
        mViewModel.setRepository(AppViewModelFactory.getInstance().getRepository());

        setStatusBarColor(this, R.color.colorPrimary);
        setAndroidNativeLightStatusBar(this, false);
    }

    /**
     * 修改状态栏颜色，支持4.4以上版本
     *
     * @param activity
     * @param colorId
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(colorId));
        }
    }

    /**
     * 状态栏文字颜色
     *
     * @param activity
     * @param dark
     */
    public static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
