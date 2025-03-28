package com.example.ecotrip5.Hem;

public class ReseAlternativ {
    private String typ; // "Samåkning", "Cykel", "Buss"
    private String beskrivning;

    public ReseAlternativ(String typ, String beskrivning) {
        this.typ = typ;
        this.beskrivning = beskrivning;
    }

    public String getTyp() { return typ; }
    public String getBeskrivning() { return beskrivning; }
}

