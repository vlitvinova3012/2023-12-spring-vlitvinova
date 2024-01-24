package ru.diasoft.spring.vlitvinova.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.diasoft.spring.vlitvinova.dto.Question;
import ru.diasoft.spring.vlitvinova.exception.ResourceNotFoundException;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class QuestionDaoImplTest {
    @Test
    void testGetQuestionListWithValidFile() {
        QuestionDaoImpl questionDao = new QuestionDaoImpl("questions.csv");

        List<Question> questionList = questionDao.getQuestionList();

        Assertions.assertEquals(5, questionList.size());

        Question question1 = questionList.get(0);
        Assertions.assertEquals("What is the year now?", question1.getQuestionFromFile());
        Assertions.assertEquals(Arrays.asList("2022", "2023", "2024"), question1.getAnswers());
        Assertions.assertEquals(List.of("2"), question1.getRightAnswers());
    }

    @Test
    void testGetQuestionListWithInvalidFile() {
        QuestionDaoImpl questionDao = new QuestionDaoImpl("nonexistent.txt");
        Assertions.assertThrows(ResourceNotFoundException.class, questionDao::getQuestionList);
    }
}