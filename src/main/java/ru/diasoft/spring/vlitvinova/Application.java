package ru.diasoft.spring.vlitvinova;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.diasoft.spring.vlitvinova.configuration.AppConfig;
import ru.diasoft.spring.vlitvinova.service.ProcessAnswerService;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProcessAnswerService processAnswerService = context.getBean(ProcessAnswerService.class);
        processAnswerService.processAnswers();

    }

}
