package com.example.kyrsach2.Servise;

import com.example.kyrsach2.exceptions.NotFoundQuestionsException;
import com.example.kyrsach2.model.Question;
import com.example.kyrsach2.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    static List<Question> QUESTIONS = List.of(
            new Question("test1", "test11"),
            new Question("test2", "test22"),
            new Question("test3", "test33"),
            new Question("test4", "test44"));
    @Mock
    JavaQuestionRepository repository;
    @InjectMocks
    JavaQuestionService service;


    @BeforeEach
    void setUp() {
        when(repository.getAll()).thenReturn(QUESTIONS);
    }

    @Test
    void testRandomQuestion() {
        for (int i = 0; i < 100; i++) {
            assertTrue(QUESTIONS.contains(service.getRandomQuestion()));
        }


    }

    @Test
    void testEmptyQuestions() {
        when(repository.getAll()).thenReturn(List.of());
        assertThrows(NotFoundQuestionsException.class, () -> service.getRandomQuestion());
    }
}