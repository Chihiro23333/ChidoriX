package com.bilibili.designpatterncomponent.visitorsample;

/**
 * @author 朱峰 2019/8/2
 */
public class StdLowVisitor extends BaseVisitor {
    @Override
    public String getBasePath() {
        return "E:\\Chidori\\ChidoriX\\ChidoriX\\designpatterncomponent\\src\\main\\java\\com\\bilibili\\designpatterncomponent\\visitorsample";
//        return RouteUtils.getStdLowFolderPath();
    }
}
