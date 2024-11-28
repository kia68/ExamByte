package com.example.exambyte.controller;

import com.example.exambyte.applicationService.TestService;
import com.example.exambyte.config.OrganizatorOnly;
import com.example.exambyte.domainLayer.model.Email;
import com.example.exambyte.domainLayer.model.Test;
import com.example.exambyte.domainLayer.model.User;
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

    @GetMapping
    public String load(Model model){
        model.addAttribute("user", testService.userList());
        return "home";
    }
    @GetMapping("/tests")
    public String tests(Model model, OAuth2AuthenticationToken auth){
        String login = auth.getPrincipal().getAttribute("login");
        System.out.println(auth);
        model.addAttribute("name", login);
        model.addAttribute("tests", testService.getTests());
        return "tests";
    }

    @PostMapping
    public String register(OAuth2AuthenticationToken auth, Email email, String action){
        String login = auth.getPrincipal().getAttribute("login");
        User user = new User(email);
        //model.addAttribute("user", user);
        testService.userList().add(user);
//        model.addAttribute("user", userList);
//        System.out.println(testService.userList());
//        System.out.println(action);
        return "redirect:/";
    }


    @GetMapping("/addAufgabe")
    @OrganizatorOnly
    public String aufgabe(Model model){
        model.addAttribute("aufgabe", testService.getTests());
        return "addAufgabe";
    }

//    @PostMapping("/create")
//    public void createAufgabe(Model model, AufgabenForm aufgabenForm){
//        Aufgaben aufgaben;
//        if ("MultipleChoice".equals(aufgabenForm.type())){
//            aufgaben = new MultipleChoiceAufgabe(aufgabenForm.titel(),
//                    aufgabenForm.punkt(), aufgabenForm.);
//        }
//        else {
//
//        }
//    }


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
        return "redirect:/tests";
    }



}
