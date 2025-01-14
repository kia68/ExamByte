package com.example.exambyte.controller;

import com.example.exambyte.applicationService.TestService;
import com.example.exambyte.domainLayer.model.Aufgabe;
import com.example.exambyte.domainLayer.model.Test;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ExamByte {


    private TestService testService;

    public ExamByte(TestService test) {
        this.testService = test;
    }

    @GetMapping()
    public String load(Model model, OAuth2AuthenticationToken auth){
        String login = auth.getPrincipal().getAttribute("login");
        System.out.println(login);
        model.addAttribute("name", login);
        model.addAttribute("tests", testService.getTests());
        return "home";
    }


    @GetMapping("/addTest")
    public String showAddTestForm(TestForm testForm){
        return "addTest";
    }

    @PostMapping("/addTest")
    public String addTest(TestForm testForm){
        Test test = new Test(testForm.getName(),
                LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(1),
                testForm.getAufgaben());
        testService.addTest(test);
        System.out.println("Test added: " + test.getName());
        return "redirect:/";
    }
    @GetMapping("/addAufgabe")
    public String showAddAufgabe(AufgabenForm aufgabenForm){
        return "addAufgabe";
    }

    @PostMapping("/addAufgabe")
    public String addAufgabe(AufgabenForm aufgabenForm){
        Aufgabe aufgabe = new Aufgabe(aufgabenForm.getTitle(),
                aufgabenForm.getPunkt(),
                aufgabenForm.getType(),
                aufgabenForm.getAufgabe());
        testService.addAufgabe(aufgabe);
        System.out.println("Aufgabe added: " + aufgabe.getTitle());
        return "redirect:/test";
    }
    @GetMapping("/test")
    public String aufgabe(Model model, AufgabenForm aufgabenForm){
        model.addAttribute("aufgabens", testService.getAufgaben());
        model.addAttribute("tests", testService.getTests());
        System.out.println("get aufgabe");
        return "test";
    }
    @GetMapping("/wochentest")
    public String showWeekTest(@RequestParam int id, Model model) {
        Test test = testService.getTestById(id);
        model.addAttribute("test", test);
        model.addAttribute("aufgabens", testService.getAufgaben());
        return "wochenTest";
    }




}
