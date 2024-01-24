package ru.diasoft.spring.vlitvinova.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IOConsoleServiceImplTest {
    @Mock
    private Scanner scanner;
    private final Question question = new Question();
    private final IOConsoleService service = new IOConsoleServiceImpl();
    @Test
    void testPrintFirstInfo(){
        service.printFirstInfo(scanner);
        verify(scanner, times(1)).nextLine();
    }
    @Test
    void testRightAnswer(){
        List<String> rightAnswers = new ArrayList<>();
        rightAnswers.add("1");
        rightAnswers.add("2");
        question.setRightAnswers(rightAnswers);
        when(scanner.nextLine()).thenReturn("1,2");
        int score = service.testUser(scanner,question);
        assertEquals(1, score);
    }
    @Test
    void testWrongAnswer(){
        List<String> rightAnswers = new ArrayList<>();
        rightAnswers.add("1");
        rightAnswers.add("3");
        question.setRightAnswers(rightAnswers);
        when(scanner.nextLine()).thenReturn("2");
        int score = service.testUser(scanner,question);
        assertEquals(0, score);
    }
}