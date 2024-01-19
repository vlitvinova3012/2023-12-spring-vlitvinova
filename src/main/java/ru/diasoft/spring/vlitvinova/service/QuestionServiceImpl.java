package ru.diasoft.spring.vlitvinova.service;

import lombok.RequiredArgsConstructor;
import ru.diasoft.spring.vlitvinova.dao.QuestionDao;
import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final IOConsoleService ioConsoleService;

    @Override
    public void testUser() {
        Scanner scanner = new Scanner(System.in);
        ioConsoleService.printFirstInfo(scanner);
        List<Question> questionList = questionDao.getQuestionList();
        AtomicInteger score = new AtomicInteger();
        questionList.forEach(question -> {
            System.out.println(question.getQuestionFromFile());
            List<String> answers = question.getAnswers();
            IntStream.range(0, answers.size())
                    .forEach(i -> System.out.println((i + 1) + ". " + answers.get(i)));
            if (ioConsoleService.testUser(scanner, question) != 0){
                score.getAndIncrement();
            }
            System.out.println("---------------------------");
        });
        System.out.println("Your score " + score + "/5");
    }

}
