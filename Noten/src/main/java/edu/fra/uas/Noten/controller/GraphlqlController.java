package edu.fra.uas.Noten.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import edu.fra.uas.Noten.service.NotenService;

@Controller
public class GraphlqlController {

    private static final Logger log = LoggerFactory.getLogger(GraphlqlController.class);

    @Autowired
    NotenService notenService;

    @MutationMapping
    public double addNote(@Argument double note) {
        log.debug("addNote() is called");
        if (note < 1 || note > 6) {
            log.error("Note ungültig. Muss zwischen 1 und 6 liegen.");
            throw new IllegalArgumentException("Note muss zwischen 1 und 6 liegen.");
        }
        notenService.addNote(note);
        return note;
    }

    @MutationMapping
    public List<Double> getNotenListe() {
        log.debug("getNotenListe() is called");
        return notenService.getNotenliste();
    }

    @MutationMapping
    public int deleteNote(@Argument int id) {
        log.debug("deleteNote() is called");
        notenService.deleteNote(id);
        return id;
    }

    @QueryMapping
    public double getDurchschnitt() {
        log.debug("getDurchschnitt() is called");
        return notenService.berechneDurchschnitt();
    }

    @QueryMapping
    public List<Double> getNotenliste() {
        log.debug("getNoteById() is called");
        return notenService.getNotenliste();
    }
}
