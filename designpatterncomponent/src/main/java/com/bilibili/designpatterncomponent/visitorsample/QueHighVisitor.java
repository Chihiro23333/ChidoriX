package com.bilibili.designpatterncomponent.visitorsample;

/**
 * @author 朱峰 2019/8/2
 */
public class QueHighVisitor extends BaseVisitor {
    @Override
    public String getBasePath() {
        return RouteUtils.getQueHighFolderPath();
    }
}
