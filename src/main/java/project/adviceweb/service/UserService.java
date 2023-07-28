package project.adviceweb.service;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import project.adviceweb.dto.UserDto;
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
    public List<User> findUserByAnswerProvided(String answerProvided) {
        List<User> user2 = userRepository.findUserByAnswerProvided(answerProvided);
        if (answerProvided == null)
            throw new AnswerNotFoundException("Answer not found", 1);
        return userRepository.findUserByAnswerProvided(answerProvided);
    }

    @SneakyThrows
    public List<User> findUserByCommentsAdded(String content) {
        List<User> user3 = userRepository.findUserByCommentsAdded(content);
        if (content == null)
            throw new CommentNotFoundException("Comment not found", 3);
        return userRepository.findUserByCommentsAdded(content);
    }

    public UserDto save(Long id, UserDto userDto) {
        User user = toUser(id, userDto);
        User savedUser = userRepository.save(user);
        return toUserDto(savedUser);
    }

    private User toUser(Long id, UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDisplayedName(userDto.getDisplayedName());
        return user;
    }

    private UserDto toUserDto(User savedUser) {
        UserDto savedUserDto = new UserDto();
        savedUserDto.setId(savedUser.getUserId());
        savedUserDto.setDisplayedName(savedUser.getDisplayedName());
        savedUserDto.setPassword(savedUser.getPassword());
        savedUserDto.setEmail(savedUser.getEmail());
        return savedUserDto;
    }
}
