package com.bilibili.designpatterncomponent.visitorsample;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱峰 2019/8/1
 */
public class FileNode implements Node {

    private Visitor visitor;

    private String wholeName;

    private String location;

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("wholeName", wholeName);
        map.put("location", location);
        map.put("basepath", visitor.getBasePath());
        return new Gson().toJson(map);
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public void setLocation(String location) {
        this.location = location;
        //获取文件的全名称
        File file = new File(location);
        if (file.exists()) {
            this.wholeName = file.getName();
        }
    }

    public String getLocation() {
        return location;
    }
}
