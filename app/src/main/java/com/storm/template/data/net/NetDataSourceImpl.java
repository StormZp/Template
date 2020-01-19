package com.storm.template.data.net;

import com.storm.template.data.net.service.Api;

public class NetDataSourceImpl implements NetDataSource {

    private volatile static NetDataSourceImpl INSTANCE = null;
    private Api api;

    public NetDataSourceImpl(Api api) {
        this.api = api;
    }

    public static NetDataSourceImpl getInstance(Api api) {
        if (INSTANCE == null)
            synchronized (NetDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NetDataSourceImpl(api);
                }
            }
        return INSTANCE;
    }


//    @Override
//    public Observable<List<VersionBean>> getMeterVersion(String sixteenCode) {
//        return api.getVersion(sixteenCode).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }
//
//    @Override
//    public Observable<JsonObject> getAppVersion() {
//        return api.getAppVersion().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }
}
