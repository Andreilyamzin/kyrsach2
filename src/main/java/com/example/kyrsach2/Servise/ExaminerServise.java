package com.example.kyrsach2.Servise;

import com.example.kyrsach2.model.Question;

import java.util.Collection;

public interface ExaminerServise {
    Collection<Question> getQuestion(int amount);
}
