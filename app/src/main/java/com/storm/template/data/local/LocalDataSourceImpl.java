package com.storm.template.data.local;

public class LocalDataSourceImpl implements LocalDataSource {
    private static LocalDataSourceImpl instance;

    public static LocalDataSourceImpl getInstance() {
        if (instance == null)
            synchronized (LocalDataSourceImpl.class) {
                if (instance == null)
                    instance = new LocalDataSourceImpl();
            }
        return instance;
    }
}
