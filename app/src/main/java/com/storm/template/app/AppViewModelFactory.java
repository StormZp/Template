package com.storm.template.app;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.storm.template.data.Repository;
import com.storm.mylibrary.utils.Utils;
import com.storm.template.module.viewpage.page1.ViewPagerEmptyViewModel;

public class AppViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile AppViewModelFactory INSTANCE;
    private final Application mApplication;
    private final Repository mRepository;


    private AppViewModelFactory(Application application, Repository repository) {
        this.mApplication = application;
        this.mRepository = repository;

    }

    public static AppViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (AppViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppViewModelFactory(Utils.getContext(), Injection.provideDemoRepository());
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

//        if (modelClass.isAssignableFrom(ViewPagerEmptyViewModel.class)) {
//            return (T) new ViewPagerEmptyViewModel(mRepository);
//        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
