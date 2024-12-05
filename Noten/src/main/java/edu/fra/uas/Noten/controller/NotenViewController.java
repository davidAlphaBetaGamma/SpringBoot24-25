package edu.fra.uas.Noten.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.fra.uas.Noten.service.NotenService;

@Controller
public class NotenViewController {


    private final Logger log = org.slf4j.LoggerFactory.getLogger(NotenViewController.class);
    
    @Autowired
    private NotenService notenService;


    @RequestMapping
    public String get() {
     log.debug("get() is called");
     return "index.html";  
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showNotenView(Model model) {
        model.addAttribute("noten", notenService.getNotenliste());
        model.addAttribute("durchschnitt", notenService.berechneDurchschnitt());
        return "list.html"; // Rendert die Datei src/main/resources/templates/index.html
    }

    @RequestMapping("/add")
    public String addNote(@RequestParam("note") Double note) {
        if(note != null && note >= 1 && note <= 6) {
            notenService.addNote(note);
        }
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") int id) {
        List<Double> notenListe = notenService.getNotenliste();
        if(id >= 0 && id < notenListe.size()) {
            notenService.deleteNote(id);
        }
        return "delete";
    }
}
