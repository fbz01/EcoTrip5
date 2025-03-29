package com.example.ecotrip5.DinaResor;

public class Resa {
    // Variabler för information om resan
    private String title;
    private String start;
    private String end;
    private String tid;

    // Konstruktor för att skapa en ny resa
    public Resa(String title, String start, String end, String tid) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.tid = tid;
    }

    // Get metoder för att hämta information om resan
    public String getTitle(){ return title; }
    public String getStart() { return start; }
    public String getEnd() { return end; }
    public String getTid() { return tid; }
}

