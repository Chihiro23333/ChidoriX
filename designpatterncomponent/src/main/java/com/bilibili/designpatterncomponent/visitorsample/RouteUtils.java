package com.bilibili.designpatterncomponent.visitorsample;

import java.io.File;

/**
 * @author 朱峰 2019/8/1
 */
public class RouteUtils {
    private static final String F_CFG = "cfg";
    private static final String F_STD = "std";
    private static final String F_QUE = "que";

    private static final String F_LOW = "low";
    private static final String F_MID = "mid";
    private static final String F_HIGH = "hight";

    private static final String BASE_PATH = "";

    public static String getCfgFolderPath() {
        return BASE_PATH + F_CFG;
    }

    public static String getStdFolderPath() {
        return BASE_PATH + F_STD;
    }

    public static String getStdLowFolderPath() {
        return getStdFolderPath() + File.separator + F_LOW;
    }

    public static String getStdMidFolderPath() {
        return getStdFolderPath() + File.separator + F_MID;
    }

    public static String getStdHighFolderPath() {
        return getStdFolderPath() + File.separator + F_HIGH;
    }


    public static String geQueFolderPath() {
        return BASE_PATH + F_QUE;
    }

    public static String getQueLowFolderPath() {
        return geQueFolderPath() + File.separator + F_LOW;
    }

    public static String getQueMidFolderPath() {
        return geQueFolderPath() + File.separator + F_MID;
    }

    public static String getQueHighFolderPath() {
        return geQueFolderPath() + File.separator + F_HIGH;
    }
}
