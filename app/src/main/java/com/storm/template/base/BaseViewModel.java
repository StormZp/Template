package com.storm.template.base;

import com.storm.mylibrary.base.SuperBaseViewModel;
import com.storm.template.data.Repository;

public abstract class BaseViewModel  extends SuperBaseViewModel {

    private  Repository mRepository;
    public void setRepository(Repository repository){
        mRepository = repository;
        initData();
    }

    protected abstract void initData();
}
