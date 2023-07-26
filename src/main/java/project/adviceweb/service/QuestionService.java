package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.model.Question;
import project.adviceweb.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question findAsker(Long userId) {
        return questionRepository.findAsker(userId);
    }

    public List<Question> findQuestionByTags()  {
        return questionRepository.findQuestionsByTags();
    }

}
