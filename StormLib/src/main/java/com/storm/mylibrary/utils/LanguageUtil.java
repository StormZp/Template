package com.storm.mylibrary.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import com.storm.mylibrary.SharedPreferences.SPUtils;

import java.util.Locale;


public class LanguageUtil {
    public static final String LANGUAGE = "rx_language";

    public static void switchLanguage(Locale locale, Context context) {
        Resources resources = context.getResources();// 获得res资源对象
        Configuration cfg = resources.getConfiguration();// 获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();// 获得屏幕参数：主要是分辨率，像素
        cfg.locale = locale;
        resources.updateConfiguration(cfg, dm);
    }


    public static void initLanguage(Context context) {
        String language = (String) SPUtils.getInstance().getString(LANGUAGE, "unknown");
        assert language != null;
        if (language.equals("unknown")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                language = LocaleList.getDefault().get(0).getLanguage();
            } else
                language = Locale.getDefault().getLanguage();
        }
        switchLanguage(new Locale(language, ""), context);
//        Preferences.setParam(context, Preferences.PreKey.LANGUAGE_NEW, language);
        SPUtils.getInstance().put(LANGUAGE, language);
    }

    public static void changeLanguage(Context context, String language) {
        SPUtils.getInstance().put(LANGUAGE, language);
        initLanguage(context);
    }

    /**
     * 根据语言获取货币
     *
     * @param language
     * @return
     */
    public static String getSymbol(String language) {
        String symbol;
        switch (language) {
            case "zh": // 简体中文
                symbol = "CNY";
                break;
            case "fr": //法语
                symbol = "EUR";
                break;
            case "de": //德语
                symbol = "EUR";
                break;
            case "it": //意大利语
                symbol = "EUR";
                break;
            case "es": //西班牙语
                symbol = "EUR";
                break;
            case "cs": //捷克语
                symbol = "CZK";
                break;
        /*   case "da": //丹麦语
                symbol = "DKK";
                break;
            case "mn": //蒙古语
                symbol = "MNT";
                break;*/
            case "ru"://俄语
                symbol = "RUB";
                break;
            case "uk": //乌克兰语
                symbol = "UAH";
                break;
          /*   case "tr": //土耳其语
                symbol = "TRY";
                break;*/
            case "sk": //斯洛伐克语
                symbol = "EUR";
                break;
            case "tr": //土耳其语
                symbol = "TRY";
                break;

            default:
                symbol = "$/£";
                break;
        }
        return symbol;
    }

    /**
     * 根据语言发送给服务器的值
     *
     * @param language
     * @return
     */
    public static int getServerPosition(String language) {
        int languagePosition;
        switch (language) {
            case "zh": // 简体中文
                languagePosition = 1;
                break;
            case "fr": //法语
                languagePosition = 3;
                break;
            case "de": //德语
                languagePosition = 2;
                break;
            case "it": //意大利语
                languagePosition = 4;
                break;
            case "es": //西班牙语
                languagePosition = 5;
                break;
            case "cs": //捷克语
                languagePosition = 10;
                break;
            /*   case "da": //丹麦语
                languagePosition = 8;
                break;
            case "mn": //蒙古语
                languagePosition = 12;
                break;*/
            case "ru"://俄语
                languagePosition = 13;
                break;
            case "uk": //乌克兰语
                languagePosition = 14;
                break;
            case "sk": //斯洛伐克语
                languagePosition = 15;
                break;
            case "tr": //土耳其语
                languagePosition = 18;
                break;
            case "en": //英语
                languagePosition = 19;
                break;

            default:
                languagePosition = 0;
                break;
        }
        return languagePosition;
    }
}
