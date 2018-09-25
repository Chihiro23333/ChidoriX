package com.bilibili.designpatterncomponent.visitor.normal;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

    private List<Node> nodes = new ArrayList<>();

    public void add(Node node) {
        nodes.add(node);
    }

    public void action(Visitor visitor) {
        for (Node node :
                nodes) {
            node.accept(visitor);
        }
    }
}
