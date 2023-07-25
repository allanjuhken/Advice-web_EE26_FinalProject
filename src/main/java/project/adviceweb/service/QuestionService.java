package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.model.Question;
import project.adviceweb.repository.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

}
