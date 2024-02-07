package ru.diasoft.spring.vlitvinova.service;

import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@SuppressWarnings("squid:S106")
public class IOServiceImpl implements IOService {
    @Override
    public void printWelcomeInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name and surname");
        scanner.nextLine();
        System.out.println("Please, answer the questions below.\n");
    }

    @Override
    public void printQuestionWithPossibleAnswers(Question question) {
        System.out.println(question.getQuestionFromFile());
        List<String> answers = question.getAnswers();
        IntStream.range(0, answers.size())
                .forEach(i -> System.out.println((i + 1) + ". " + answers.get(i)));
        System.out.println("Please, list number of answers, using \",\"");
    }

    @Override
    public List<String> getUserAnswers() {
        Scanner scanner = new Scanner(System.in);
        String userAnswers = scanner.nextLine();
        return Arrays.asList(userAnswers.replace(" ", "").split(","));
    }

    @Override
    public void printAnswer(boolean isRightAnswer) {
        if (isRightAnswer) {
            System.out.println("Right");
        } else {
            System.out.println("Wrong");
        }
    }

    @Override
    public void splitSections() {
        System.out.println("---------------------------");
    }

    @Override
    public void getResultScore(AtomicInteger score) {
        System.out.println("Your score " + score + "/5");
    }


}
