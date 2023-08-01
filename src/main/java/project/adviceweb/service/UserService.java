package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.dto.UserDto;
import project.adviceweb.exception.AnswerNotFoundException;
import project.adviceweb.exception.CommentNotFoundException;
import project.adviceweb.exception.QuestionNotFoundException;
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

    public List<User> findUserByQuestionAsked(String content)
            throws QuestionNotFoundException {
        if (content == null)
            throw new QuestionNotFoundException("Question not found", 4);
        return userRepository.findUserByQuestionAsked(content);
    }

    public List<User> findUserByAnswerProvided(String answerProvided) throws AnswerNotFoundException {
        if (answerProvided == null)
            throw new AnswerNotFoundException("Answer not found", 1);
        return userRepository.findUserByAnswerProvided(answerProvided);
    }

    public List<User> findUserByCommentsAdded(String content) throws CommentNotFoundException {
        if (content == null)
            throw new CommentNotFoundException("Comment not found", 3);
        return userRepository.findUserByCommentsAdded(content);
    }

    public UserDto save(Long id, UserDto userDto) {
        User user = toUser(id, userDto);
        User savedUser = userRepository.save(user);
        return toUserDto(savedUser);
    }

    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).orElse(null);
        if (user != null) {
            user.setDisplayedName(userDto.getDisplayedName());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        }
    }

    private User toUser(Long userId, UserDto userDto) {
        User user = new User();
        user.setUserId(userId);
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDisplayedName(userDto.getDisplayedName());
        return user;
    }

    private UserDto toUserDto(User savedUser) {
        UserDto savedUserDto = new UserDto();
        savedUserDto.setId(savedUser.getUserId());
        savedUserDto.setDisplayedName(savedUser.getDisplayedName());
        savedUserDto.setEmail(savedUser.getEmail());
        savedUserDto.setPassword(savedUser.getPassword());
        return savedUserDto;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}