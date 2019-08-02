package com.bilibili.designpatterncomponent.visitorsample;

import com.google.gson.Gson;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 朱峰 2019/8/1
 */
public class FolderNode implements Node {

    private Visitor visitor;

    private String wholeName;

    private String location;

    private List<Node> children;

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getJson() {
        if (visitor == null) throw new RuntimeException("no visitor");
        if(children == null){
            children = new ArrayList<>();
        }
        String absolutLoc = visitor.getBasePath() + getLocation();
        if (absolutLoc != null && absolutLoc.length() > 0) {
            File file = new File(absolutLoc);
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files.length > 0) {
                    for (int i = 0; i < files.length; i++) {
                        File file1 = files[i];
                        if (file1.isDirectory()) {
                            FolderNode folderNode = new FolderNode();
                            folderNode.setLocation(getLocation() + File.separator + file1.getName());
                            folderNode.setWholeName(file1.getName());
                            children.add(folderNode);
                        } else {
                            FileNode fileNode = new FileNode();
                            fileNode.setLocation(getLocation() + File.separator + file1.getName());
                            fileNode.setWholeName(file1.getName());
                            children.add(fileNode);
                        }
                    }
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("location", location);
        map.put("wholeName", wholeName);
        map.put("children", children);
        map.put("basepath", visitor.getBasePath());
        return new Gson().toJson(map);
    }

    public String getLocation() {
        return location == null ? "" : location;
    }

    public String getWholeName() {
        return wholeName;
    }

    public void setWholeName(String wholeName) {
        this.wholeName = wholeName;
    }

    public void setLocation(String location) {
        this.location = location;
        setChildren(new ArrayList<Node>());
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
