package edu.fra.uas.Noten.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.fra.uas.Noten.service.NotenService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/restful")
public class NotenController {

    public static final Logger log = org.slf4j.LoggerFactory.getLogger(NotenController.class);

    @Autowired
    private NotenService notenService;

    @PostMapping(value = "/noten", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody Double note) {
        if (note == null || note < 1 || note > 6) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Invalid-Note", "true");
            headers.add("X-Suggestion", "Gültige Werte sind zwischen 1 und 6.");

            return ResponseEntity.badRequest().headers(headers)
                    .body("Ungültige Note. Bitte Zahl zwischen 1 und 6 eingeben");
        }
        notenService.addNote(note);
        log.info("add() is called");

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Note-Added", "true");
        headers.add("X-Note-Value", note.toString());
        headers.add("Location", "/noten/ausgeben");

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("Note hinzugefügt: " + note);
    }

    @GetMapping(value = "/notenListe", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Double>> getNotenliste() {
        List<Double> notenListe = new ArrayList<>();
        for (double note : notenService.getNotenliste()) {
            notenListe.add(note);
        }
        if (notenListe.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<List<Double>>(notenListe, HttpStatus.OK);
    }

    @GetMapping(value = "/noten/durchschnitt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Double> getDurchschnitt() {
        return ResponseEntity.ok(notenService.berechneDurchschnitt());
    }

    @DeleteMapping(value = "/notenListe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> deleteNote(@PathVariable("id") int notenId) {
        log.info("delete() is called");
        List<Double> notenListe = notenService.getNotenliste();
        if (notenId < 0 || notenListe.size() < notenId) {
            return ResponseEntity.notFound().build();
        }
        notenService.deleteNote(notenId);
        return ResponseEntity.ok("Note gelöscht");
    }

}
