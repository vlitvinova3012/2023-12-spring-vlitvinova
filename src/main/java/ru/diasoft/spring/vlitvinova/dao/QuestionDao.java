package ru.diasoft.spring.vlitvinova.dao;

import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.List;

public interface QuestionDao {
    public List<Question> getQuestionList();
}
