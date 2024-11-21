package com.example.Notendurchschnitt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notendurchschnitt.model.Note;

@Service
public class CalcAvg {

    public List<Note> kurse = new ArrayList<>();

    public CalcAvg() {
        Note mathe = new Note();
        Note deutsch = new Note();
        mathe.setNote(2.5);
        deutsch.setNote(1.3);
        mathe.setBeschreibung("Mathe");
        deutsch.setBeschreibung("Deutsch");

        kurse.add(mathe);
        kurse.add(deutsch);
    }

    public double berechneDurchschnitt(List<Note> kurs) {
        double sum = 0;
        for (int i = 0; i < kurs.size(); i++) {
            sum += kurs.get(i).getNoten();
        }

        return sum / kurs.size();
    }

    public void getDurchschnitt() {
        System.out.println(berechneDurchschnitt(kurse));
    }
}
