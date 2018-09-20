package com.bilibili.designpatterncomponent.builder_one;

public class Builder {
    private Message message;

    public Builder() {
        message = new Message();
    }

    public Builder setFrom(String from) {
        message.setFrom(from);
        return this;
    }

    public Builder setTo(String to) {
        message.setTo(to);
        return this;
    }

    public Builder setTime(String time) {
        message.setTime(time);
        return this;
    }

    public Builder setContent(String content) {
        message.setContent(content);
        return this;
    }


    public Builder setTitle(String title) {
        message.setTitle(title);
        return this;
    }

    public Message build() {
        return message;
    }
}
