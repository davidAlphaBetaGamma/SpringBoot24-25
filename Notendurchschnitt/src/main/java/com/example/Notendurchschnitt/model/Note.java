package com.example.Notendurchschnitt.model;

public class Note {

    private double wert;
    private String beschreibung;

    public Note() {
    }

    public void setNote(double value) {
        wert = value;
    }

    public double getNoten() {
        return wert;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
