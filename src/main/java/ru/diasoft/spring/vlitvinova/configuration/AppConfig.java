package ru.diasoft.spring.vlitvinova.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.spring.vlitvinova.service.IOConsoleService;
import ru.diasoft.spring.vlitvinova.service.IOConsoleServiceImpl;
import ru.diasoft.spring.vlitvinova.service.QuestionService;
import ru.diasoft.spring.vlitvinova.service.QuestionServiceImpl;
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
    public IOConsoleService consoleService() {
        return new IOConsoleServiceImpl();
    }

    @Bean
    public QuestionService questionService(QuestionDao questionDao, IOConsoleService consoleService) {
        return new QuestionServiceImpl(questionDao, consoleService);
    }
}
