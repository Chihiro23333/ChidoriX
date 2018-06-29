package com.bilibili.diyrouter_compiler.model;

import com.bilibili.diyrouter_annotation.annotation.BindView;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

public class BindViewField {
    private VariableElement variableElement;
    private int resid;

    public BindViewField(Element element, int resid) {
        if (element.getKind() != ElementKind.FIELD) {
            throw new IllegalArgumentException("只能在field上使用这个bindview注解");
        }
        variableElement = (VariableElement) element;
        BindView annotation = variableElement.getAnnotation(BindView.class);
        resid = annotation.value();
        if (resid < -1) {
            throw new IllegalArgumentException("bindview resid不能小于-1");
        }
    }

    public Name getFiledName() {
        return variableElement.getSimpleName();
    }

    public int getResid() {
        return resid;
    }

    public TypeMirror getFieldType() {
        return variableElement.asType();
    }
}
