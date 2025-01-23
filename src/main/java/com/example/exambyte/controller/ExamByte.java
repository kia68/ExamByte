package com.example.exambyte.controller;

import com.example.exambyte.applicationService.ExamService;
import com.example.exambyte.domainLayer.model.exam.Exam;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class ExamByte {


    private ExamService examService;

    public ExamByte(ExamService test) {
        this.examService = test;
    }

    @GetMapping()
    public String load(Model model, OAuth2AuthenticationToken auth){
        String login = auth.getPrincipal().getAttribute("login");
        System.out.println(login);
        model.addAttribute("name", login);
        model.addAttribute("tests", examService.getExam());
        return "home";
    }


    @GetMapping("/addTest")
    public String showAddTestForm(ExamForm examForm){
        return "addTest";
    }

    @PostMapping("/addTest")
    public String addTest(ExamForm testForm, String name){
        Exam test = new Exam(name);
        examService.addExam(test);
        System.out.println("Test added: " + test.getName());
        return "redirect:/";
    }
    @GetMapping("/wochentest/{id}")
    public String showWeekTest(@PathVariable UUID id, Model model) {
        Exam exam = examService.getExamById(id);
        model.addAttribute("exam", exam);
        //model.addAttribute("tests", testService.getTests());
        return "wochentest";
    }
//    @GetMapping("/addAufgabe")
//    public String showAddAufgabe(AufgabenForm aufgabenForm){
//        return "addAufgabe";

//    }
//    @PostMapping("/addAufgabe")
//    public String addAufgabe(AufgabenForm aufgabenForm){
//        Aufgabe aufgabe = new Aufgabe(aufgabenForm.getTitle(),
//                aufgabenForm.getPunkt(),
//                aufgabenForm.getType(),
//                aufgabenForm.getAufgabe());
//        testService.addAufgabe(aufgabe);
//        System.out.println("Aufgabe added: " + aufgabe.getTitle());
//        return "redirect:/test";
//    }
//    @GetMapping("/test")
//    public String aufgabe(Model model, @RequestParam UUID aufgabeId){
//        model.addAttribute("aufgabens", examService.getAufgaben(aufgabeId));
//        model.addAttribute("tests", examService.getExam());
//        System.out.println("get aufgabe");
//        return "test";
//    }




}
