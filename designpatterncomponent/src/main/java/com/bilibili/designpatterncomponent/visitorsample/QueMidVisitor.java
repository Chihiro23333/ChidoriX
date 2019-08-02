package com.bilibili.designpatterncomponent.visitorsample;

/**
 * @author 朱峰 2019/8/2
 */
public class QueMidVisitor extends BaseVisitor {
    @Override
    public String getBasePath() {
        return RouteUtils.getQueMidFolderPath();
    }
}
