package project.adviceweb.service;

import org.springframework.stereotype.Service;
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

    public List<User> findAllUsersByQuestionAsked(String content) {
        return userRepository.findAllQuestionAsked(content);
    }

    public List<User> findAllUsersByAnswersProvided(String content) {
        return userRepository.findAllAnswersProvided(content);
    }

    public List<User> findAllUsersByCommentsAdded(String content) {
        return userRepository.findAllCommentsAdded(content);
    }
}
