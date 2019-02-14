package com.bilibili.threadcomponent.future.sample;

public class Host {

    public FutureData request(final int count, final char c) {

        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }

}
