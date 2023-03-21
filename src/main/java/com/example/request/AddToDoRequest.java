package com.example.request;

public class AddToDoRequest {
    private String content;

    public AddToDoRequest() {
    }

    public AddToDoRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
