package com.bilibili.threadcomponent.future.sample;

public class RealData implements Data {

    private String content;

    public RealData(int count, char c) {
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            slowly();
            buffer[i] = c;
        }
        content = new String(buffer);
    }

    @Override
    public String getContent() {
        return content;
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
