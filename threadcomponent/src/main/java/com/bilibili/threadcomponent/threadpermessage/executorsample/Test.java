package com.bilibili.threadcomponent.threadpermessage.executorsample;

import androidx.annotation.Nullable;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class Test {

    public static void main(String args[]) {
        System.out.println("MAIN BEGIN");
        Host host = new Host(new Executor() {
            @Override
            public void execute(@NonNull Runnable command) {
                new Thread(command).start();
            }
        });
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("MAIN END");
    }

}
