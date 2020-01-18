package com.storm.mylibrary.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.Map;

public class UIChangeLiveData extends MutableLiveData{
    private MutableLiveData<String> showDialogEvent;
    private MutableLiveData<Void> dismissDialogEvent;
    private MutableLiveData<Map<String, Object>> startActivityEvent;
    private MutableLiveData<Map<String, Object>> startNavEvent;
    private MutableLiveData<Void> finishEvent;
    private MutableLiveData<Void> onBackPressedEvent;

    public MutableLiveData<String> getShowDialogEvent() {
        return showDialogEvent =createLiveData(showDialogEvent);
    }


    public MutableLiveData<Void> getDismissDialogEvent() {
        return dismissDialogEvent=createLiveData(dismissDialogEvent);
    }


    public MutableLiveData<Map<String, Object>> getStartActivityEvent() {
        return startActivityEvent=createLiveData(startActivityEvent);
    }


    public MutableLiveData<Map<String, Object>> getStartNavEvent() {
        return startNavEvent =createLiveData(startNavEvent);
    }


    public MutableLiveData<Void> getFinishEvent() {
        return finishEvent=createLiveData(finishEvent);
    }


    public MutableLiveData<Void> getOnBackPressedEvent() {
        return onBackPressedEvent=createLiveData(onBackPressedEvent);
    }


    private MutableLiveData createLiveData(MutableLiveData liveData) {
        if (liveData == null) {
            liveData = new MutableLiveData();
        }
        return liveData;
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
        super.observe(owner, observer);
    }

    public static final class ParameterField {
        public static String INTENT = "intent";
        public static String CLASS = "CLASS";
        public static String BUNDLE = "BUNDLE";

        public static String NAV_ID = "NAV_ID";
    }
}
