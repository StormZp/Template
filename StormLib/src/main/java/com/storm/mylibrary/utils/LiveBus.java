package com.storm.mylibrary.utils;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.annotations.NonNull;

/**
 * 事件总线
 *
 * @author：tqzhang on 18/9/11 17:22
 */
public class LiveBus {

    private static volatile LiveBus instance;

    private final Map<Object, MutableLiveData<Object>> mLiveBus;

    private LiveBus() {
        mLiveBus = new HashMap<>();
    }

    public static LiveBus getDefault() {
        if (instance == null) {
            synchronized (LiveBus.class) {
                if (instance == null) {
                    instance = new LiveBus();
                }
            }
        }
        return instance;
    }

    public <T> MutableLiveData<T> subscribe(Object eventKey) {
        return (MutableLiveData<T>) subscribe(eventKey, Object.class);
    }

    public <T> MutableLiveData<T> subscribe(Object eventKey, Class<T> tMutableLiveData) {
        if (!mLiveBus.containsKey(eventKey)) {
            mLiveBus.put(eventKey, new LiveBusData<>(true));
        } else {
            LiveBusData liveBusData = (LiveBusData) mLiveBus.get(eventKey);
            liveBusData.isFirstSubscribe = false;
        }

        return (MutableLiveData<T>) mLiveBus.get(eventKey);
    }

    public <T> MutableLiveData<T> postEvent(Object eventKey, T value) {
        MutableLiveData<T> mutableLiveData = subscribe(eventKey);
        mutableLiveData.postValue(value);
        return mutableLiveData;
    }

    public static class LiveBusData<T> extends MutableLiveData<T> {

        private boolean isFirstSubscribe;

        public LiveBusData(boolean isFirstSubscribe) {
            this.isFirstSubscribe = isFirstSubscribe;
        }

        @Override
        public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
            super.observe(owner, new ObserverWrapper<>(observer, isFirstSubscribe));
        }
    }

    private static class ObserverWrapper<T> implements Observer<T> {
        private Observer<T> observer;

        private boolean isChanged;

        private ObserverWrapper(Observer<T> observer, boolean isFirstSubscribe) {
            this.observer = observer;
            isChanged = isFirstSubscribe;
        }

        @Override
        public void onChanged(@Nullable T t) {
            if (isChanged) {
                if (observer != null) {
                    observer.onChanged(t);
                }
            } else {
                isChanged = true;
            }
        }
    }
}

