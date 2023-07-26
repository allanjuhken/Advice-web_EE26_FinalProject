package project.adviceweb.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import project.adviceweb.exception.AnswerNotFoundException;
import project.adviceweb.exception.CommentNotFoundException;
import project.adviceweb.exception.QuestionNotFoundException;
import project.adviceweb.exception.UserNotFoundException;
import project.adviceweb.model.Question;
import project.adviceweb.model.User;
import project.adviceweb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @SneakyThrows
    public List<User> findUserByQuestionAsked(String content)
    throws UserNotFoundException {
        List<User> user1 = userRepository.findUserByQuestionAsked(content);
        if (content == null)
            throw new QuestionNotFoundException("Question not found", 4);
        return userRepository.findUserByQuestionAsked(content);
    }

    @SneakyThrows
    public List<User> findUserByAnswerType(String answerType) {
        List<User> user2 = userRepository.findUserByAnswerType(answerType);
        if (answerType == null)
            throw new AnswerNotFoundException("Answer not found", 1);
        return userRepository.findUserByAnswerType(answerType);
    }

    @SneakyThrows
    public List<User> findUserByCommentsAdded(String content) {
        List<User> user3 = userRepository.findUserByCommentsAdded(content);
        if (content == null)
            throw new CommentNotFoundException("Comment not found", 3);
        return userRepository.findUserByCommentsAdded(content);
    }
}
