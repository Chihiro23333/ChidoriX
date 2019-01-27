package com.bilibili.threadcomponent.balking.sample;

public class Data {
    private String filename;
    private String content = "";
    private boolean changed = false;

    public Data(String filename ,String content ) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        changed = true;
    }

    public synchronized void save() {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + "call doSave content=" + content);
    }
}
