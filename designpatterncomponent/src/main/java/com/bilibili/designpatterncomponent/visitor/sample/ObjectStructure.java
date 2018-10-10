package com.bilibili.designpatterncomponent.visitor.sample;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {
    private List<Person> personList = new ArrayList<>();

    public void add(Person person){
        personList.add(person);
    }

    public void remove(Person person){
        personList.remove(person);
    }

    public void visitAll(Visitor visitor){
        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).accept(visitor);
        }
    }
}
