package com.bilibili.diyrouter_compiler;

import com.bilibili.diyrouter_annotation.annotation.BindView;
import com.bilibili.diyrouter_compiler.model.AnnotatedClass;
import com.bilibili.diyrouter_compiler.model.BindViewField;

import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class BindViewProcessor extends AbstractProcessor {

    private Elements elementUtils;
    private Filer filer;

    private Map<String, AnnotatedClass> mAnnotataedClassMap;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        elementUtils = processingEnvironment.getElementUtils();
        filer = processingEnvironment.getFiler();
        mAnnotataedClassMap = new HashMap<>();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        mAnnotataedClassMap.clear();

        try {
        //循环找出BindView注解
        for (Element element : roundEnvironment.getElementsAnnotatedWith(BindView.class)) {
            TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
            String fullClassName = enclosingElement.getQualifiedName().toString();
            AnnotatedClass annotatedClass = mAnnotataedClassMap.get(fullClassName);
            if (annotatedClass == null) {
                annotatedClass = new AnnotatedClass(enclosingElement, elementUtils);
                mAnnotataedClassMap.put(fullClassName, annotatedClass);
            }

            BindViewField bindViewField = new BindViewField(element);
            annotatedClass.addFild(bindViewField);
        }
            //生成java文件
            for (AnnotatedClass annotatedClass : mAnnotataedClassMap.values()) {
                annotatedClass.generateFinder().writeTo(filer);
            }
        } catch (Exception e) {

        }

        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(BindView.class.getCanonicalName());
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
