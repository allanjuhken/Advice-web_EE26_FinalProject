package project.adviceweb.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import project.adviceweb.exception.QuestionNotFoundException;
import project.adviceweb.exception.UserNotFoundException;
import project.adviceweb.model.Question;
import project.adviceweb.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @SneakyThrows
    public Question findAsker(Long userId)
        throws UserNotFoundException {
        Question question = questionRepository.findAsker(userId);
        if (userId == null)
            throw new QuestionNotFoundException("Question not found", 4);
        return questionRepository.findAsker(userId);
    }

    public List<Question> findQuestionByTags()  {
        return questionRepository.findQuestionsByTags();
    }
}
