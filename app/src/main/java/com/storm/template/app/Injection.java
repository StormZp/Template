package com.storm.template.app;

import com.storm.template.data.Repository;
import com.storm.template.data.ble.BleDataSourceImpl;
import com.storm.template.data.local.LocalDataSourceImpl;
import com.storm.template.data.net.NetDataSourceImpl;
import com.storm.template.data.net.service.Api;
import com.storm.mylibrary.utils.RetrofitClient;
import com.storm.mylibrary.utils.Utils;


/**
 * 注入全局的数据仓库，可以考虑使用Dagger2。（根据项目实际情况搭建，千万不要为了架构�?�架构）
 * Created by goldze on 2019/3/26.
 */
public class Injection {
    public static Repository provideDemoRepository() {
//         //网络API服务
//        DemoApiService apiService = RetrofitClient.getInstance().create(DemoApiService.class);
//        //网络数据源
//        HttpDataSource httpDataSource = HttpDataSourceImpl.getInstance(apiService);
//        //本地数据源
//        LocalDataSource localDataSource = LocalDataSourceImpl.getInstance();


        //两条分支组成一个数据仓库
        return Repository.getInstance(
                LocalDataSourceImpl.getInstance(),
                BleDataSourceImpl.getInstance(Utils.getContext()),
                NetDataSourceImpl.getInstance(RetrofitClient.getInstance().create(Api.class))
        );
    }
}
