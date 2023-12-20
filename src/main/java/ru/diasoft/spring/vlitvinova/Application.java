package ru.diasoft.spring.vlitvinova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.diasoft.spring.vlitvinova.QuestionService.QuestionService;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.printQuestions();
    }

}
