package com.bilibili.threadcomponent.threadspecificstorage;

public class ClientThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            Log.print();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.close();
    }
}
