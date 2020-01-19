package com.storm.template.data.net.service;

import com.google.gson.JsonObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
//    @GET("/")
//    Observable<List<VersionBean>> getVersion(@Query("SN") String sixteenCode);

    @GET("?cmd=602&json={\"package\":\"com.revogi.delite\"}")
    Observable<JsonObject> getAppVersion();


}
