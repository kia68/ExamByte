package com.example.exambyte.controller;

import com.example.exambyte.applicationService.ExamService;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/aufgabe")
public class AufgabeController {

    private final ExamService examService;

    public AufgabeController(ExamService examService) {
        this.examService = examService;
    }

    // Anzeigen aller Aufgaben
    @GetMapping
    public String showAllAufgaben(Model model, AufgabenForm aufgabenForm) {
        model.addAttribute("aufgabenForm", examService.getAufgaben());
        return "aufgabe"; // Thymeleaf-Template aufgabe.html
    }

    @GetMapping("/aufgabe/{id}")
    public String showAufgabe(@RequestParam UUID id, Model model){
        Aufgabe aufgabe = examService.getAufgabeById(id);
        model.addAttribute("aufgabens", aufgabe);
        return "aufgabe";
    }

    // Formular zum Hinzufügen einer neuen Aufgabe anzeigen
    @GetMapping("/addAufgabe")
    public String showAddAufgabeForm(AufgabenForm aufgabenForm) {
        return "addAufgabe"; // Thymeleaf-Template addAufgabe.html
    }

    // Eine neue Aufgabe hinzufügen
    @PostMapping("/addAufgabe")
    public String addAufgabe(AufgabenForm aufgabenForm) {
        Aufgabe aufgabe = new Aufgabe(
                aufgabenForm.getTitle(),
                aufgabenForm.getPunkt(),
                aufgabenForm.getType(),
                aufgabenForm.getBeschreibung()
        );
        examService.addAufgabe(aufgabe);
        System.out.println("Aufgabe added: " + aufgabe.getTitle());
        return "redirect:/";
    }

//    // Formular zum Bearbeiten einer Aufgabe anzeigen
//    @GetMapping("/edit/{id}")
//    public String showEditAufgabeForm(@PathVariable int id, Model model) {
//        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
//        model.addAttribute("aufgabe", aufgabe);
//        return "editAufgabe"; // Thymeleaf-Template editAufgabe.html
//    }
//
//    // Änderungen an einer Aufgabe speichern
//    @PostMapping("/edit/{id}")
//    public String editAufgabe(@PathVariable int id, AufgabenForm aufgabenForm) {
//        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
//        aufgabe.setTitle(aufgabenForm.getTitle());
//        aufgabe.setPunkt(aufgabenForm.getPunkt());
//        aufgabe.setType(aufgabenForm.getType());
//        testService.updateAufgabe(aufgabe); // Methode im TestService implementieren
//        return "redirect:/aufgabe";
//    }
//
//    // Eine Aufgabe löschen
//    @PostMapping("/delete/{id}")
//    public String deleteAufgabe(@PathVariable int id) {
//        testService.deleteAufgabeById(id); // Methode im TestService implementieren
//        return "redirect:/aufgabe";
//    }
//
//    // Formular zum Lösen einer Aufgabe anzeigen
//    @GetMapping("/solve/{id}")
//    public String solveAufgabe(@PathVariable int id, Model model) {
//        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
//        AufgabenForm aufgabenForm = new AufgabenForm(
//                aufgabe.getTitle(),
//                aufgabe.getPunkt(),
//                aufgabe.getType(),
//                aufgabe.getBeschreibung()
//        );
//        model.addAttribute("aufgabeForm", aufgabenForm);
//        return "aufgabe"; // Thymeleaf-Template solveAufgabe.html
//    }
//
//    // Lösung einer Aufgabe einreichen
//    @PostMapping("/solve/{id}")
//    public String submitSolution(@PathVariable int id, @RequestParam String antwort) {
//        Aufgabe aufgabe = testService.getAufgabeById(id); // Methode im TestService implementieren
//        // Hier können Sie die Logik zur Validierung oder Speicherung der Antwort implementieren
//        System.out.println("Lösung für Aufgabe " + id + ": " + antwort);
//        return "redirect:/aufgabe";
//    }
}
