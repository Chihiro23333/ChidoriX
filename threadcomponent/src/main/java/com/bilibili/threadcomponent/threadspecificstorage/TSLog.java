package com.bilibili.threadcomponent.threadspecificstorage;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {

    private PrintWriter printWriter = null;

    public TSLog(String fileName) {
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        printWriter.println(Thread.currentThread().getName()+"print");
    }

    public void close(){
        printWriter.println(Thread.currentThread().getName()+"close");
        printWriter.close();
    }
}
