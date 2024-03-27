package com.example.kyrsach2.controller;

import com.example.kyrsach2.Servise.ExaminerServise;
import com.example.kyrsach2.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping
public class ExamController {
    private final ExaminerServise service;

    public ExamController(ExaminerServise service) {
        this.service = service;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return service.getQuestion(amount);

    }
}
