package com.example.exambyte.controller;

import com.example.exambyte.applicationService.TestService;
import com.example.exambyte.domainLayer.model.Aufgabe;
import com.example.exambyte.domainLayer.model.Test;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class ExamByte {


    private TestService testService;

    public ExamByte(TestService test) {
        this.testService = test;
    }

    @GetMapping("/home")
    public String load(Model model, OAuth2AuthenticationToken auth){
        String login = auth.getPrincipal().getAttribute("login");
        System.out.println(login);
        model.addAttribute("name", login);
        model.addAttribute("tests", testService.getTests());

        //model.addAttribute("user", testService.userList());
        return "home";
    }
//    @GetMapping("/tests")
//    public String tests(Model model, OAuth2AuthenticationToken auth){
//        String login = auth.getPrincipal().getAttribute("login");
//        System.out.println(auth);
//        model.addAttribute("name", login);
//        model.addAttribute("tests", testService.getTests());
//        return "tests";
//    }

//    @PostMapping
//    public String register(OAuth2AuthenticationToken auth, Email email, String action){
//        String login = auth.getPrincipal().getAttribute("login");
//        User user = new User(email);
//        //model.addAttribute("user", user);
//        testService.userList().add(user);
//        return "redirect:/";
//    }


    //@OrganizatorOnly


    @GetMapping("/addTest")
    public String addTest(TestForm testForm){
        System.out.println("Get addTest Done");
        return "addTest";
    }

    @PostMapping("/addTest")
    public String addTest(Model model, TestForm testForm){
        Test test = new Test(testForm.getId() ,testForm.getName(), LocalDateTime.now(), LocalDateTime.now().plusWeeks(1),
                testForm.getAufgabens());
        testService.addTest(test);
        System.out.println("post addtest done");
        return "redirect:/home";
    }
    @GetMapping("/aufgabe")
    public String aufgabe(Model model, AufgabenForm aufgabenForm){
        Aufgabe aufgabe = new Aufgabe(aufgabenForm.getTitle(), aufgabenForm.getPunkt(), aufgabenForm.getType());
        testService.addAufgabe(aufgabe);
        //model.addAttribute("aufgabe", aufgabenForm);
        System.out.println("get aufgabe");
        return "aufgabe";
    }

    @GetMapping("/addAufgabe")
    public String addAufgabe(Model model){
        //model.addAttribute("aufgabe", testService.getAufgaben());
        System.out.println("get addaufgabe");
        return "addAufgabe";
    }

    @PostMapping("/addAufgabe")
    public String createAufgabe(Model model, Aufgabe aufgabe){
        //Aufgabe aufgabe1 = new Aufgabe("aufgabe", )
        model.addAttribute("aufgabe", aufgabe);
        System.out.println("post addaufgabe");
        return "redirect:/aufgabe";
    }



}
