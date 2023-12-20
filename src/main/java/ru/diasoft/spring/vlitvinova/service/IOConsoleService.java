package ru.diasoft.spring.vlitvinova.service;

import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.Scanner;

public interface IOConsoleService {
    public void printFirstInfo(Scanner scanner);
    public int testUser(Scanner scanner, Question question);

}
