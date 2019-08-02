package com.bilibili.designpatterncomponent.visitorsample;

/**
 * @author 朱峰 2019/8/1
 */
public interface Visitor {

    int TYPE_QUE_LOW = 0;
    int TYPE_QUE_MID = 1;
    int TYPE_QUE_HIGH = 2;
    int TYPE_STD_LOW = 3;
    int TYPE_STD_MID = 4;
    int TYPE_STD_HIGH = 5;

    String visit(FolderNode folderNode);

    String visit(FileNode fileNode);

    String visit(ConfigNode configNode);

    String getBasePath();
}
