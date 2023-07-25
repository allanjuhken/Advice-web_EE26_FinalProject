package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.model.User;
import project.adviceweb.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }



}
