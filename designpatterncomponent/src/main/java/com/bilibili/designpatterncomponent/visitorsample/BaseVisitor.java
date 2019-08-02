package com.bilibili.designpatterncomponent.visitorsample;

import java.io.IOException;

/**
 * @author 朱峰 2019/8/1
 */
public abstract class BaseVisitor implements Visitor {

    @Override
    public String visit(FolderNode folderNode) {
        return folderNode.getJson();
    }

    @Override
    public String visit(FileNode fileNode) {
        return fileNode.getJson();
    }

    @Override
    public String visit(ConfigNode configNode) {
        try {
            return configNode.getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
