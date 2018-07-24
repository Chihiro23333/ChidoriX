package com.bilibili.diyrouter_compiler;

import com.bilibili.diyrouter_annotation.annotation.Explain;
import com.google.auto.service.AutoService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.prefs.AbstractPreferences;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Created by Chihiro on 2018/7/24.
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({"com.bilibili.diyrouter_annotation.annotation.Explain"})
public class ExplainProcessor extends AbstractProcessor {


    private Elements elementUtils;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        elementUtils = processingEnvironment.getElementUtils();
        filer = processingEnvironment.getFiler();
    }


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if(set !=null && set.size() >0){
            Set<? extends Element> routeNodes = roundEnvironment.getElementsAnnotatedWith(Explain.class);
            generateRouterTable(routeNodes);
            return true;
        }
        return false;
    }

    /**
     * generate HostRouterTable.txt
     * @param routeNodes
     */
    private void generateRouterTable(Set<? extends Element> routeNodes) {
        String fileName =  "./UIRouterTable/" + "ExplainTable" + ".txt";
        if (createFile(fileName)) {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("auto generated, do not change !!!! \n\n");

            for (Element typeElement : routeNodes) {

                TypeElement typeElement1 = (TypeElement) typeElement;

                String packageName = getPackageName(typeElement1);
                String className = getClassName(typeElement1, packageName);

                stringBuilder.append(packageName + "\n");
                stringBuilder.append(className + "\n");

                Explain annotation = typeElement.getAnnotation(Explain.class);
                stringBuilder.append(annotation.desc()+"\n");
            }
            writeStringToFile(fileName, stringBuilder.toString(), false);
        }
    }


    public String getPackageName(TypeElement typeElement){
        return elementUtils.getPackageOf(typeElement).getQualifiedName().toString();
    }

    //获取类名
    private static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen).replace('.', '$');
    }

    /**
     * @param fileName
     */
    public  boolean createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * @param fileName
     * @param content
     */
    public  void writeStringToFile(String fileName, String content, boolean append) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName, append), "UTF-8"));
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
