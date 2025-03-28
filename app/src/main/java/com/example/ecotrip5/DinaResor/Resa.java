package com.example.ecotrip5.DinaResor;

public class Resa {
    private String title;
    private String start;
    private String end;
    private String tid;

    public Resa(String title, String start, String end, String tid) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.tid = tid;
    }
    public String getTitle(){ return title; }
    public String getStart() { return start; }
    public String getEnd() { return end; }
    public String getTid() { return tid; }
}

