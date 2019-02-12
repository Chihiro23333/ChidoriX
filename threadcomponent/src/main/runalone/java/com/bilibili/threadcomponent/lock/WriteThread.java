package com.bilibili.threadcomponent.lock;

public class WriteThread extends Thread {

    private Data data;
    private int index = 0;
    private String str;

    public WriteThread(Data data, String str) {
        this.data = data;
        this.str = str;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            data.write(str.charAt(index % str.length()));
            index++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
