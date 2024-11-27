package edu.fra.uas.Noten.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.Noten.service.NotenService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/noten")
public class NotenController {

    @Autowired
    private NotenService notenService;

    @PostMapping("/add")
    public String addNote(@RequestParam double note) {
        // TODO: process POST request
        notenService.addNote(note);
        return "Note hinzugefügt: " + note;
    }

    @GetMapping("/ausgeben")
    public List<Double> getNotenliste() {
        return notenService.getNotenliste();
    }

    @GetMapping("/durchschnitt")
    public double getDurchschnitt() {
        return notenService.berechneDurchschnitt();
    }

    @PostMapping("/entfernen")
    public String deleteNote(@RequestParam int value) {
        // TODO: process POST request
        notenService.deleteNote(value);
        return "Note gelöscht";
    }

}
