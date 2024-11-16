package com.example.exambyte.controller;

import com.example.exambyte.Email;
import com.example.exambyte.service.TestService;
import com.example.exambyte.test.Test;
import com.example.exambyte.users.Role;
import com.example.exambyte.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String tests(Model model){
        model.addAttribute("tests", testService.getTests());
        return "tests";
    }

    @PostMapping
    public String register(Email email, Role role, String action){
        User user = new User(email, role);
        //model.addAttribute("user", user);
        testService.userList().add(user);
//        model.addAttribute("user", userList);
//        System.out.println(testService.userList());
//        System.out.println(action);
        return "redirect:/";
    }


    @GetMapping("/addAufgabe")
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
        Test test = new Test(testForm.id() ,testForm.name(), LocalDateTime.now(), LocalDateTime.now().plusWeeks(1),
                testForm.aufgabens());
        testService.addTest(test);
        System.out.println("post addtest done");
        return "redirect:/tests";
    }



}
