package com.bilibili.designpatterncomponent.chainofresponsibility.sample;

public class Test {
    public static void main(String args[]) {
        Handler projectManager = new ProjectManager();
        Handler deptManager = new DeptManager();
        Handler generalManager = new GeneralManager();

        projectManager.setNext(deptManager);
        deptManager.setNext(generalManager);

        projectManager.handRequest(300, "张三");
        projectManager.handRequest(800, "李四");
        projectManager.handRequest(2000, "王五");
    }
}
