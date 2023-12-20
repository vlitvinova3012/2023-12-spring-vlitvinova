package ru.diasoft.spring.vlitvinova.QuestionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.spring.vlitvinova.dao.QuestionDao;
import ru.diasoft.spring.vlitvinova.dto.Question;
import ru.diasoft.spring.vlitvinova.service.IOConsoleService;
import ru.diasoft.spring.vlitvinova.service.QuestionServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionDao questionDao;
    @Mock
    IOConsoleService consoleService;

    private QuestionServiceImpl questionService;


    @BeforeEach
    public void setUp() {
        questionService = new QuestionServiceImpl(questionDao, consoleService);
    }

    @Test
    void testPrintQuestions() {

        List<Question> questionList = Arrays.asList(
                new Question("What is your favorite color?", Arrays.asList("Red", "Blue", "Green"), List.of("1")),
                new Question("What is your favorite animal?", Arrays.asList("Dog", "Cat", "Bird"), List.of("1"))
        );

        when(questionDao.getQuestionList()).thenReturn(questionList);
        when(consoleService.testUser(any(Scanner.class), any(Question.class))).thenReturn(1);


        questionService.testUser();

        verify(questionDao, times(1)).getQuestionList();
    }

}