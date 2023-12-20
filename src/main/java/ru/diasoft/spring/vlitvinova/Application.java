package ru.diasoft.spring.vlitvinova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.diasoft.spring.vlitvinova.service.QuestionService;
import ru.diasoft.spring.vlitvinova.configuration.AppConfig;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.testUser();
    }

}
