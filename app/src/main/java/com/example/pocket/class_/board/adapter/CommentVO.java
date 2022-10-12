package com.example.pocket.class_.board.adapter;

public class CommentVO {

    private String  seq;
    private String id;
    private String content;
    private String date;

    public CommentVO(String seq, String id, String content, String date) {
        this.seq = seq;
        this.id = id;
        this.content = content;
        this.date = date;
    }

    public String getSeq() {
        return seq;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
