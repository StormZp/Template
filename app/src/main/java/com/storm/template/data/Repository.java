package com.storm.template.data;

import com.storm.template.data.ble.BleDataSource;
import com.storm.template.data.local.LocalDataSource;
import com.storm.template.data.net.NetDataSource;
import com.storm.template.data.net.NetDataSourceImpl;

public class Repository implements LocalDataSource, BleDataSource, NetDataSource {
    private volatile static Repository INSTANCE = null;
    private final LocalDataSource localDataSource;
    private final BleDataSource bleDataSource;
    private final NetDataSource netDataSource;


    private Repository(LocalDataSource localDataSource, BleDataSource bleDataSource, NetDataSourceImpl netDataSource) {
        this.localDataSource = localDataSource;
        this.bleDataSource = bleDataSource;
        this.netDataSource = netDataSource;
    }

    public static Repository getInstance(LocalDataSource localDataSource, BleDataSource bleDataSource, NetDataSourceImpl netDataSource) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(localDataSource, bleDataSource, netDataSource);
                }
            }
        }
        return INSTANCE;
    }


}
