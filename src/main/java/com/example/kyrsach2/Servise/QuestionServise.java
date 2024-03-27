package com.example.kyrsach2.Servise;

import com.example.kyrsach2.model.Question;

import java.util.Collection;

public interface QuestionServise {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
