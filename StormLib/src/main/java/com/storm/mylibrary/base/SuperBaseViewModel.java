package com.storm.mylibrary.base;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.storm.mylibrary.utils.TUtil;
import com.storm.mylibrary.utils.Utils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SuperBaseViewModel extends ViewModel implements LifecycleObserver {
    public Application application;
    protected UIChangeLiveData uc;
    //管理RxJava，主要针对RxJava异步操作造成的内存泄漏
    private CompositeDisposable mCompositeDisposable;

    public SuperBaseViewModel() {
        this.application = Utils.getContext();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onPause() {
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestory() {
        //ViewModel销毁时会执行，同时取消所有异步任务
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    public UIChangeLiveData getUC() {
        if (uc == null) {
            uc = new UIChangeLiveData();
        }
        return uc;
    }

    public void toast(String msg) {
        TUtil.getInstance().s(msg);
    }

    public void toast(int msg) {
        TUtil.getInstance().s(msg);
    }


    public void startNav(int actionRes) {
        this.startNav(actionRes, null);
    }

    public void startNav(int actionRes, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(UIChangeLiveData.ParameterField.NAV_ID, actionRes);
        if (bundle != null) {
            params.put(UIChangeLiveData.ParameterField.BUNDLE, bundle);
        }
        uc.getStartNavEvent().postValue(params);
    }

    public void startActivity(Class<?> clz) {
        this.startActivity(clz, null);
    }

    public void startActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(UIChangeLiveData.ParameterField.CLASS, clz);
        if (bundle != null) {
            params.put(UIChangeLiveData.ParameterField.BUNDLE, bundle);
        }
        uc.getStartActivityEvent().postValue(params);
    }

    public void startActivity(Intent intent) {
        Map<String, Object> params = new HashMap<>();
        params.put(UIChangeLiveData.ParameterField.INTENT, intent);
        uc.getStartActivityEvent().postValue(params);
    }


    public void showProgress(String title) {
        uc.getShowDialogEvent().postValue(title);
    }
    public void showProgress() {
        uc.getShowDialogEvent().postValue("");
    }

    public void dismissProgress() {
        uc.getDismissDialogEvent().postValue(null);
    }


//            //加载对话框显示
//            mViewModel.getUC().getShowDialogEvent().observe(this, new Observer<String>() {
//        @Override
//        public void onChanged(@Nullable String title) {
//            showDialog(title);
//        }
//    });
//    //加载对话框消失
//        mViewModel.getUC().getDismissDialogEvent().observe(this, new Observer<Void>() {
//        @Override
//        public void onChanged(@Nullable Void v) {
//            dismissDialog();
//        }
//    });

    public void finish() {
        uc.getFinishEvent().postValue(null);
    }

    public void onBackPressed() {
        uc.getOnBackPressedEvent().postValue(null);
    }
}
