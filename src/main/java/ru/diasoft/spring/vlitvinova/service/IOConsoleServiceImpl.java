package ru.diasoft.spring.vlitvinova.service;

import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IOConsoleServiceImpl implements IOConsoleService {
    @Override
    public void printFirstInfo(Scanner scanner) {
        System.out.println("Enter your name and surname");
        scanner.nextLine();
        System.out.println("Please, answer the questions below.\n");
    }

    @Override
    public int testUser(Scanner scanner, Question question) {
        int score = 0;
        System.out.println("Please, list number of answers, using \",\"");
        String userAnswers = scanner.nextLine();
        List<String> listAnswers = Arrays.asList(userAnswers.replace(" ", "").split(","));
        List<String> rightAnswers = question.getRightAnswers();
        boolean isRight = isRightAnswer(listAnswers, rightAnswers);
        if (!isRight) {
            System.out.println("Wrong");
        } else {
            System.out.println("Right");
            score++;
        }
        return score;
    }

    private Boolean isRightAnswer(List<String> listAnswers, List<String> rightAnswers) {
        if (listAnswers.size() == rightAnswers.size()) {
            Collections.sort(listAnswers);
            Collections.sort(rightAnswers);
            return listAnswers.equals(rightAnswers);
        }
        return false;
    }
}
