package com.bilibili.threadcomponent.threadspecificstorage;

public class Log {

    private static final ThreadLocal<TSLog> tsCollections = new ThreadLocal<>();

    public static void print(){
        getTSLog().print();
    }

    public static void close(){
        getTSLog().close();
    }

    private static TSLog getTSLog(){
        TSLog tsLog = tsCollections.get();
        if(tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName()+getTSLog()+"-log.txt");
        }
        return tsLog;
    }

}
