package ru.diasoft.spring.vlitvinova.QuestionService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.diasoft.spring.vlitvinova.dao.QuestionDao;
import ru.diasoft.spring.vlitvinova.dto.Question;

import java.util.List;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    @Override
    public void printQuestions() {
        List<Question> questionList = questionDao.getQuestionList();
        questionList.forEach(question -> {
            System.out.println(question.getQuestionFromFile());
            List<String> answers = question.getAnswers();
            IntStream.range(0, answers.size())
                    .forEach(i -> System.out.println((i + 1) + ". " + answers.get(i)));
            System.out.println("---------------------------");
        });
    }
}
