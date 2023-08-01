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

    public List<Question> findByUserId(Long userId)
            throws UserNotFoundException, QuestionNotFoundException {
        if (userId == null)
            throw new QuestionNotFoundException("Question not found", 4);
        return questionRepository.findByUser_UserId(userId);
    }

    public List<Question> findQuestionsByTags(String tagName) {
        return questionRepository.findByTags_Name(tagName);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> findQuestionByCategory(String categoryName) throws QuestionNotFoundException {
        if (categoryName == null || categoryName.isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        List<Question> questions = questionRepository.findQuestionByCategory(categoryName);
        if (questions == null || questions.isEmpty()) {
            throw new QuestionNotFoundException("Questions not found for category: " + categoryName, 4);
        }

        return questions;
    }

    public Question findQuestionByQuestionId(Long questionId) throws QuestionNotFoundException {
        if (questionId == null) {
            throw new IllegalArgumentException("Question ID cannot be null");
        }

        Question question = questionRepository.findQuestionByQuestionId(questionId);
        if (question == null) {
            throw new QuestionNotFoundException("Question not found for ID: " + questionId, 4);
        }

        return question;
    }
}
