package com.storm.template.app;

public class Constants {

    public static final String BLUETOOTHNAME = "CLIPMETER"; // 蓝牙模块名字
    public static final String SP_NAME = "sharedPreferences"; // 本地缓存名字
    public static final int BLE_SACN_TIME = 8; // 蓝牙搜索十秒
    public static final String DEFAULT_PASSWORD = "0000";
    public static final String BUGLY_ID = "f9daa4b34b";

    public static final String MAIN_TO_SCAN = "main_to_scan";//从首页进搜索
    public static final String SERVER_URL = "http://upgrade.revogi.com";
    public static final String SHARE_URL = "https://www.maxhauri.ch/faq.html";


    /*------------------------------  设备三种状�??  ------------------------------*/
    public static final int DISCONNECTED = 0; // 断开连接
    public static final int CONNECTING = 1; // 正在连接
    public static final int CONNECTED = 2; // 已经连接�?

    /*__________________________________  蓝牙  __________________________________*/
    public static final String UUID_SERVICE = ("0000fff0-0000-1000-8000-00805f9b34fb"); //服务
    public static final String UUID_VERSION = ("0000fff1-0000-1000-8000-00805f9b34fb"); //获取版本
    public static final String UUID_WRITE = ("0000fff3-0000-1000-8000-00805f9b34fb");//写数�?
    public static final String UUID_NOTIFY = ("0000fff4-0000-1000-8000-00805f9b34fb");//读数�?


    public static final String UUID_SERVICE_NAME = ("00001800-0000-1000-8000-00805f9b34fb");//获取名字
    public static final String UUID_READ_NAME = ("00002a00-0000-1000-8000-00805f9b34fb");//获取名字

}
