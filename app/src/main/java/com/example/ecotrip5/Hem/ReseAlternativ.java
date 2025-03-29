package com.example.ecotrip5.Hem;

public class ReseAlternativ {
    // Variabler för typ av resa ("Samåka" eller "Buss") och beskrivning av alternativet
    private String typ;
    private String beskrivning;

    // Konstruktor för att skapa nytt resealternativ
    public ReseAlternativ(String typ, String beskrivning) {
        this.typ = typ;
        this.beskrivning = beskrivning;
    }
    // Hämta typ av resealternativ
    public String getTyp() { return typ; }
    // Hämta beskrivning av resealternativ
    public String getBeskrivning() { return beskrivning; }
}

