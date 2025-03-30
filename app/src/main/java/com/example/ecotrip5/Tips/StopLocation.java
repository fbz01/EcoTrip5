package com.example.ecotrip5.Tips;

// -------------------------------------------------------------
// Denna klass har skapats med stöd av ChatGPT (OpenAI).
// ChatGPT användes för att utforma en enkel modellklass baserat på
// API-strukturen från ResRobot och för att dokumentera getter-metoderna.
// -------------------------------------------------------------

public class StopLocation {
    // Variabler för information om hållplatsen
    private String name;
    private double dist;
    private String extId;

    // Hämtar det externa ID:t
    public String getExtId() {
        return extId;
    }

    // Hämtar namnet på hållplatsen
    public String getName() {
        return name;
    }

    // Hämtar avståndet till hållplatsen
    public double getDist() {
        return dist;
    }
}


