package com.storm.template.data.ble;

import android.app.Application;
import android.content.Context;

import com.clj.fastble.BleManager;
import com.clj.fastble.callback.BleReadCallback;
import com.clj.fastble.callback.BleWriteCallback;
import com.clj.fastble.data.BleDevice;
import com.clj.fastble.exception.BleException;
import com.storm.template.app.Constants;
import com.storm.template.app.MyApp;
import com.storm.template.data.local.LocalDataSourceImpl;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class BleDataSourceImpl implements BleDataSource {

    private static BleDataSourceImpl instance;

    public static BleDataSourceImpl getInstance(Application context) {
        if (instance == null)
            synchronized (BleDataSourceImpl.class) {
                if (instance == null) {
                    instance = new BleDataSourceImpl();
                    BleManager.getInstance().init(context);
                }

            }
        return instance;
    }


    private Single<byte[]> readCharacteristic(BleDevice bleDevice, String service, String read) {
        return Single.create(new SingleOnSubscribe<byte[]>() {

            @Override
            public void subscribe(SingleEmitter<byte[]> emitter) throws Exception {
                BleManager.getInstance().read(
                        bleDevice,
                        service,
                        read, new BleReadCallback() {
                            @Override
                            public void onReadSuccess(byte[] data) {
                                emitter.onSuccess(data);
                            }

                            @Override
                            public void onReadFailure(BleException exception) {
                                emitter.onError(new Throwable(exception.toString()));
                            }
                        });

            }
        });
    }

    private Single<byte[]> writeCharacteristic(BleDevice bleDevice, String uuid, byte[] cmd) {
        return Single.create(new SingleOnSubscribe<byte[]>() {
            @Override
            public void subscribe(SingleEmitter<byte[]> emitter) throws Exception {
                BleManager.getInstance().write(
                        bleDevice,
                        Constants.UUID_SERVICE,
                        uuid,
                        cmd,
                        new BleWriteCallback() {
                            @Override
                            public void onWriteSuccess(int current, int total, byte[] justWrite) {
                                emitter.onSuccess(justWrite);
                            }

                            @Override
                            public void onWriteFailure(BleException exception) {
                                emitter.onError(new Throwable(exception.toString()));
                            }
                        });
            }
        });
    }

    private Single<byte[]> writeCharacteristic(BleDevice bleDevice, byte[] cmd) {
        return writeCharacteristic(bleDevice, Constants.UUID_WRITE, cmd);
    }
}
