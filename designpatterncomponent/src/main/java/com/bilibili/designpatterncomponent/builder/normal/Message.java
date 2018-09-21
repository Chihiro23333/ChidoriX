package com.bilibili.designpatterncomponent.builder.normal;

public class Message {
    private String from;
    private String to;
    private String time;
    private String title;
    private String content;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void send(){
        System.out.println("from:"+from);
        System.out.println("to:"+to);
        System.out.println("time:"+time);
        System.out.println("title:"+title);
        System.out.println("content:"+content);
    }
}
