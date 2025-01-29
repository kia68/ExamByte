package com.example.exambyte.controller;

import com.example.exambyte.applicationService.AntwortService;
import com.example.exambyte.applicationService.ExamService;
import com.example.exambyte.domainLayer.model.antwort.Antwort;
import com.example.exambyte.domainLayer.model.exam.Aufgabe;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/aufgabe")
public class AufgabeController {

    private final ExamService examService;
    private final AntwortService antwortService;

    public AufgabeController(ExamService examService, AntwortService antwortService) {
        this.examService = examService;
        this.antwortService = antwortService;
    }

    @GetMapping("/{examId}")
    public String showAllAufgaben(Model model,@PathVariable UUID examId) {
        model.addAttribute("aufgabenForm", examService.getAufgaben(examId));
        model.addAttribute("examId", examId);
        return "aufgabe"; // Thymeleaf-Template aufgabe.html
    }

    // Formular zum Hinzufügen einer neuen Aufgabe anzeigen

    @GetMapping("/addAufgabe")
    public String showAddAufgabeForm(@RequestParam UUID examId, Model model) {
        if (examId == null) {
            throw new IllegalArgumentException("Exam ID must not be null");
        }
        model.addAttribute("examId", examId);
        model.addAttribute("aufgabenForm", new AufgabenForm());
        return "addAufgabe";
    }
    @PostMapping("/addAufgabe")
    public String addAufgabe(@RequestParam UUID examId, AufgabenForm aufgabenForm) {
        Aufgabe aufgabe = new Aufgabe(
                aufgabenForm.getTitle(),
                aufgabenForm.getPunkt(),
                aufgabenForm.getType(),
                aufgabenForm.getBeschreibung()
        );
        examService.addAufgabeToExam(examId, aufgabe);
        System.out.println("Aufgabe added: " + aufgabe.getTitle());
        return "redirect:/";
    }

    @GetMapping("/{examId}/{aufgabeId}")
    public String showAufgabe(@PathVariable UUID examId,
                              @PathVariable UUID aufgabeId, Model model){
        Aufgabe aufgabe = examService.getAufgabeById(examId, aufgabeId);
        model.addAttribute("aufgabens", aufgabe);
        return "aufgabe";
    }

    @PostMapping("/{examId}/{aufgabeId}/submit")
    public String submitAntwort(@PathVariable UUID examId,
                                @PathVariable UUID aufgabeId,
                                @RequestParam String antwortText,
                                OAuth2AuthenticationToken auth){
        String gitHubLogin = auth.getPrincipal().getAttribute("login");

        Antwort antwort = new Antwort(aufgabeId, gitHubLogin, antwortText);
        antwortService.addAntwortToAufgabe(aufgabeId, gitHubLogin,antwort);
        System.out.println("Antwort gespeichert: " + antwortText);
        return "redirect:/wochentest/" + examId;
    }

//    @PostMapping("/{examId}/{aufgabeId}/delete")
//    public String deleteAufgabe(@PathVariable UUID examId, @PathVariable UUID aufgabeId) {
//        examService.deleteAufgabeById(examId, aufgabeId);
//        System.out.println("Aufgabe gelöscht mit ID: " + aufgabeId);
//        return "redirect:/aufgabe" + examId;
//    }
//
//    // Formular zum Bearbeiten einer Aufgabe anzeigen
//    @GetMapping("/edit/{id}")
//    public String showEditAufgabeForm(@PathVariable UUID examId,@PathVariable UUID aufgabeId, Model model) {
//        Aufgabe aufgabe = examService.getAufgabeById(examId,aufgabeId); // Methode im TestService implementieren
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
