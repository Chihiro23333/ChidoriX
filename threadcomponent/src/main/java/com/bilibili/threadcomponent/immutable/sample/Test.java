package com.bilibili.threadcomponent.immutable.sample;

public class Test {

    public static void main(String args[]){
        Person person = new Person("alice","beijing");
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
    }

}
