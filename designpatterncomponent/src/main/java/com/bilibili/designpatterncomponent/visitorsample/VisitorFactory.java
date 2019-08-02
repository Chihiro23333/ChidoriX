package com.bilibili.designpatterncomponent.visitorsample;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱峰 2019/8/2
 */
public class VisitorFactory {

    private static final Map<Integer, Visitor> visitorMap = new HashMap<>();

    public static Visitor create(int type) {
        return getVisitorByType(type);
    }

    private static Visitor getVisitorByType(int type) {
        Visitor cacheVisitor = visitorMap.get(type);
        if (cacheVisitor != null) return cacheVisitor;
        Visitor visitor = null;
        switch (type) {
            case Visitor.TYPE_QUE_LOW:
                visitor = new QueLowVisitor();
                break;

            case Visitor.TYPE_QUE_MID:
                visitor = new QueMidVisitor();
                break;

            case Visitor.TYPE_QUE_HIGH:
                visitor = new QueHighVisitor();
                break;

            case Visitor.TYPE_STD_LOW:
                visitor = new StdLowVisitor();
                break;

            case Visitor.TYPE_STD_MID:
                visitor = new StdMidVisitor();
                break;

            case Visitor.TYPE_STD_HIGH:
                visitor = new StdHighVisitor();
                break;

            default:
                return null;
        }
        visitorMap.put(type, visitor);
        return visitor;
    }

}
