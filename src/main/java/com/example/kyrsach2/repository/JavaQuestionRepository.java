package com.example.kyrsach2.repository;

import com.example.kyrsach2.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository ("javaRepository")
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> storage = new HashSet<>();
    @PostConstruct
    private void init(){
        storage.add(new Question("q_j1","a_j1"));
        storage.add(new Question("q_j2","a_j2"));
        storage.add(new Question("q_j3","a_j3"));


    }


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        storage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (storage.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(storage);
    }
}
