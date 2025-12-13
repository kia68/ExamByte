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
public class ExamController {

    private ExamService examService;

    public ExamController(ExamService test) {
        this.examService = test;
    }

    @GetMapping()
    public String load(Model model, java.security.Principal principal) {
        String login;
        if (principal instanceof OAuth2AuthenticationToken) {
            login = ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("login");
        } else {
            login = principal.getName();
        }
        model.addAttribute("name", login);
        model.addAttribute("tests", examService.getExam());
        return "home";
    }

    @GetMapping("/tests")
    public String showTests(Model model, java.security.Principal principal) {
        return load(model, principal);
    }

    @GetMapping("/addTest")
    public String showAddTestForm(ExamForm examForm) {
        return "addTest";
    }

    @PostMapping("/addTest")
    public String addTest(ExamForm testForm, String name) {
        Exam test = new Exam(name);
        examService.addExam(test);
        return "redirect:/";
    }

    @GetMapping("/wochentest/{id}")
    public String showWeekTest(@PathVariable UUID id, Model model) {
        Exam exam = examService.getExamById(id);
        model.addAttribute("exam", exam);
        return "wochentest";
    }

}
