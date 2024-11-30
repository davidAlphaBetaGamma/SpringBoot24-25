package edu.fra.uas.Noten.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class NotenService {

    private List<Double> noten;

    @PostConstruct
    public void initNoten() {
        noten = new ArrayList<>();
        System.out.println("Notenliste wurde initialisiert");
    }

    public double berechneDurchschnitt() {
        if (noten.isEmpty()) {
            return 0.0;
        }
        double sum = noten.stream().reduce(0.0, Double::sum);
        return sum / noten.size();
    }

    public void addNote(double note) {
        
        noten.add(note);
    }

    public List<Double> getNotenliste() {
        return noten;
    }

    public void deleteNote(int value) {
        noten.remove(value);
    }

    @PreDestroy
    public void cleanup() {
        noten.clear();
        System.out.println("Notenliste wurde geleert.");
    }
}
