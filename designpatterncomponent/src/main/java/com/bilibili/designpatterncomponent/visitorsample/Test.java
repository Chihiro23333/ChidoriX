package com.bilibili.designpatterncomponent.visitorsample;

import java.io.IOException;

/**
 * @author 朱峰 2019/8/1
 */
public class Test {
    public static void main(String args[]) {
        Visitor visitor = VisitorFactory.create(Visitor.TYPE_STD_LOW);

        ConfigNode configNode = new ConfigNode();
        configNode.setLocation("\\config.ini");
        configNode.accept(visitor);
        try {
            System.out.println(configNode.getJson());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FolderNode folderNode = new FolderNode();
        folderNode.accept(visitor);
        System.out.println(folderNode.getJson());

        FileNode fileNode = new FileNode();
        fileNode.setLocation("\\NodeFactory.java");
        fileNode.accept(visitor);
        System.out.println(fileNode.getJson());
    }
}
