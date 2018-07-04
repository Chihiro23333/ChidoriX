package com.bilibili.diyrouter_compiler.model;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class AnnotatedClass {
    private TypeElement mTypeElement;
    private Elements mElements;
    private List<BindViewField> mFilds;

    public static final ClassName FINDER = ClassName.get("com.bilbili.diyrouter_annotation_api", "Finder");
    public static final ClassName INJECTOR = ClassName.get("com.bilbili.diyrouter_annotation_api", "Injector");

    public AnnotatedClass(TypeElement mTypeElement, Elements mElements) {
        this.mTypeElement = mTypeElement;
        this.mElements = mElements;
        mFilds = new ArrayList<>();
    }

    public void addFild(BindViewField bindViewField){
        mFilds.add(bindViewField);
    }

    public String getPackageName(TypeElement typeElement){
        return mElements.getPackageOf(typeElement).getQualifiedName().toString();
    }

    //获取类名
    private static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen).replace('.', '$');
    }

    public JavaFile generateFinder(){

        //构建 inject 方法
        MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder("inject")
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override.class)
                .addParameter(TypeName.get(mTypeElement.asType()), "host", Modifier.FINAL)
                .addParameter(TypeName.OBJECT, "source")
                .addParameter(FINDER, "finder");

        //inject函数内的核心逻辑,
        // host.btn1=(Button)finder.findView(source,2131427450);  ----生成代码
        // host.$N=($T)finder.findView(source,$L)                 ----原始代码
        // 对比就会发现这里执行了实际的findViewById绑定事件
        for (BindViewField field : mFilds) {
            methodBuilder.addStatement("host.$N=($T)finder.findView(source,$L)", field.getFiledName()
                    , ClassName.get(field.getFieldType()), field.getResid());
        }

        String packageName = getPackageName(mTypeElement);
        String className = getClassName(mTypeElement, packageName);
        ClassName bindClassName = ClassName.get(packageName, className);

        TypeSpec finderClass = TypeSpec.classBuilder(bindClassName.simpleName() + "$$Injector")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(ParameterizedTypeName.get(INJECTOR, TypeName.get(mTypeElement.asType())))   //继承接口
                .addMethod(methodBuilder.build())
                .build();

        return JavaFile.builder(packageName, finderClass).build();
    }
}
