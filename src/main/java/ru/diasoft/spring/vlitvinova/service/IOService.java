package ru.diasoft.spring.vlitvinova.service;

import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface IOService {
    void printWelcomeInfo();

    void printQuestionWithPossibleAnswers(Question question);

    List<String> getUserAnswers();

    void printAnswer(boolean isRightAnswer);

    void splitSections();

    void getResultScore(AtomicInteger score);

}
