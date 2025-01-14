package com.example.exambyte.controller;

import com.example.exambyte.applicationService.TestService;
import com.example.exambyte.domainLayer.model.Aufgabe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aufgabe")
public class AufgabeController {

    private final TestService testService;

    public AufgabeController(TestService testService) {
        this.testService = testService;
    }

    // Anzeigen aller Aufgaben
    @GetMapping
    public String showAllAufgaben(Model model) {
        model.addAttribute("aufgabens", testService.getAufgaben());
        return "aufgabe"; // Thymeleaf-Template aufgabe.html
    }

    @GetMapping("/aufgabe/{id}")
    public String showAufgabe(@RequestParam int id, Model model){
        Aufgabe aufgabe = testService.getAufgabeById(id);
        model.addAttribute("aufgabens", aufgabe);
        return "aufgabe";
    }

    // Formular zum Hinzufügen einer neuen Aufgabe anzeigen
    @GetMapping("/add")
    public String showAddAufgabeForm(AufgabenForm aufgabenForm) {
        return "addAufgabe"; // Thymeleaf-Template addAufgabe.html
    }

    // Eine neue Aufgabe hinzufügen
    @PostMapping("/add")
    public String addAufgabe(AufgabenForm aufgabenForm) {
        Aufgabe aufgabe = new Aufgabe(
                aufgabenForm.getTitle(),
                aufgabenForm.getPunkt(),
                aufgabenForm.getType(),
                aufgabenForm.getAufgabe()
        );
        testService.addAufgabe(aufgabe);
        return "redirect:/aufgabe";
    }

    // Formular zum Bearbeiten einer Aufgabe anzeigen
    @GetMapping("/edit/{id}")
    public String showEditAufgabeForm(@PathVariable int id, Model model) {
        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
        model.addAttribute("aufgabe", aufgabe);
        return "editAufgabe"; // Thymeleaf-Template editAufgabe.html
    }

    // Änderungen an einer Aufgabe speichern
    @PostMapping("/edit/{id}")
    public String editAufgabe(@PathVariable int id, AufgabenForm aufgabenForm) {
        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
        aufgabe.setTitle(aufgabenForm.getTitle());
        aufgabe.setPunkt(aufgabenForm.getPunkt());
        aufgabe.setType(aufgabenForm.getType());
        aufgabe.setAufgabe(aufgabenForm.getAufgabe());
        testService.updateAufgabe(aufgabe); // Methode im TestService implementieren
        return "redirect:/aufgabe";
    }

    // Eine Aufgabe löschen
    @PostMapping("/delete/{id}")
    public String deleteAufgabe(@PathVariable int id) {
        testService.deleteAufgabeById(id); // Methode im TestService implementieren
        return "redirect:/aufgabe";
    }

    // Formular zum Lösen einer Aufgabe anzeigen
    @GetMapping("/solve/{id}")
    public String solveAufgabe(@PathVariable int id, Model model) {
        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
        model.addAttribute("aufgabe", aufgabe);
        return "solveAufgabe"; // Thymeleaf-Template solveAufgabe.html
    }

    // Lösung einer Aufgabe einreichen
    @PostMapping("/solve/{id}")
    public String submitSolution(@PathVariable int id, @RequestParam String antwort) {
        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
        // Hier können Sie die Logik zur Validierung oder Speicherung der Antwort implementieren
        System.out.println("Lösung für Aufgabe " + id + ": " + antwort);
        return "redirect:/aufgabe";
    }
}
