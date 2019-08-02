package com.bilibili.designpatterncomponent.visitorsample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 朱峰 2019/8/1
 */
public class ConfigNode implements Node {

    private Visitor visitor;

    private String wholeName;

    private String location;

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getJson() throws IOException {
        if(visitor == null)throw new RuntimeException("no visitor");
        String absolutLoc = visitor.getBasePath() + location;
        if (absolutLoc == null || absolutLoc.length() == 0) return "";
        File file = new File(absolutLoc);
        if (!file.exists()) return "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
        String line = "";
        boolean isFirstAppend = true;
        boolean needAppend = false;
        StringBuilder json = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            line = processQuestionMarks(line);
            if (line.trim() == null || line.length() == 0) continue;
            if (needAppend && !isBlock(line)) {
                line = line.replaceFirst("=", ":");
                String[] split = line.split(":");
                String zero = split[0].trim();
                String other = line.substring(zero.length()).trim();
                json.append("\"");
                json.append(zero);
                json.append("\"");
                json.append(other);
                json.append(",");
            }
            if (isBlock(line)) {
                needAppend = true;
                line = line.replaceAll("\\[", "");
                line = line.replaceAll("\\]", "");
                if (isFirstAppend) {
                    json.append("{");
                    json.append("\"");
                    json.append(line);
                    json.append("\"");
                    json.append(":{");
                    isFirstAppend = false;
                } else {
                    replaceLastComma(json);
                    json.append("},");
                    json.append("\"");
                    json.append(line);
                    json.append("\"");
                    json.append(":{");
                }
            }
        }
        replaceLastComma(json);
        json.append("}}");
        reader.close();
        reader.close();
        return new String(json.toString().getBytes(), "utf-8");
    }

    /**
     * 把其中的中文双引号变成英文
     *
     * @param str 需要替換的字符串
     * @return
     */
    public static String processQuestionMarks(String str) {
        str = str.replaceAll("”", "\"");
        str = str.replaceAll("“", "\"");
        return str;
    }

    private void replaceLastComma(StringBuilder json) {
        int last = json.lastIndexOf(",");
        json.replace(last, last + 1, "");
    }

    private boolean isBlock(String line) {
        return line.startsWith("[") && line.endsWith("]");
    }

    public String getLocation() {
        return location;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
