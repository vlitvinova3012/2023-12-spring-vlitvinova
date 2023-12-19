package ru.diasoft.spring.vlitvinova.dao;

import lombok.Data;
import ru.diasoft.spring.vlitvinova.dto.Question;
import ru.diasoft.spring.vlitvinova.exception.ResourceNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class QuestionDaoImpl implements QuestionDao {

    private String file;

    @Override
    public List<Question> getQuestionList() {
        try (InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(file)) {
            if (inputStream == null) {
                throw new ResourceNotFoundException("Resource not found: " + file);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return reader.lines()
                    .map(line -> line.split(";"))
                    .map(parts -> {
                        String question = parts[0];
                        String[] answers = Arrays.copyOfRange(parts, 1, parts.length);
                        return new Question(question, Arrays.asList(answers));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}
