package ru.diasoft.spring.vlitvinova.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.spring.vlitvinova.service.IOService;
import ru.diasoft.spring.vlitvinova.service.IOServiceImpl;
import ru.diasoft.spring.vlitvinova.service.ProcessAnswerService;
import ru.diasoft.spring.vlitvinova.service.ProcessAnswerServiceImpl;
import ru.diasoft.spring.vlitvinova.dao.QuestionDao;
import ru.diasoft.spring.vlitvinova.dao.QuestionDaoImpl;

@Configuration
public class AppConfig {
    @Value("questions.csv")
    private String file;

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoImpl(file);
    }

    @Bean
    public IOService consoleService() {
        return new IOServiceImpl();
    }

    @Bean
    public ProcessAnswerService questionService(QuestionDao questionDao, IOService consoleService) {
        return new ProcessAnswerServiceImpl(questionDao, consoleService);
    }
}
