package com.bilibili.threadcomponent.threadpermessage.threadfactorysample;

public class Helper {

    public void handle(int count, char desc) {
        System.out.println("       "  + "BEGIN:handle");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(desc);
        }
        System.out.println("       " + "END:handle");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
