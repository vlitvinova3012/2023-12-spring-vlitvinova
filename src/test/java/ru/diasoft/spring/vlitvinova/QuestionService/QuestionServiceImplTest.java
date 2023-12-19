package ru.diasoft.spring.vlitvinova.QuestionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.spring.vlitvinova.dao.QuestionDao;
import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

    @Mock
    private QuestionDao questionDao;

    private QuestionServiceImpl questionService;


    @BeforeEach
    public void setUp() {
        questionService = new QuestionServiceImpl(questionDao);
    }

    @Test
    void testPrintQuestions() {

        List<Question> questionList = Arrays.asList(
                new Question("What is your favorite color?", Arrays.asList("Red", "Blue", "Green")),
                new Question("What is your favorite animal?", Arrays.asList("Dog", "Cat", "Bird"))
        );

        when(questionDao.getQuestionList()).thenReturn(questionList);

        questionService.printQuestions();

        verify(questionDao, times(1)).getQuestionList();
    }

}