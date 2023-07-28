package project.adviceweb.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.adviceweb.model.User;
import project.adviceweb.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @SneakyThrows
    @GetMapping("/users/questions-asked/{content}")
    public ResponseEntity<List<User>> getUsersByQuestionsAsked(@PathVariable("content") String content) {
        List<User> users = userService.findUserByQuestionAsked(content);
        return ResponseEntity.ok(users);
    }

    @SneakyThrows
    @GetMapping("/users/answer-type/{answerType}")
    public ResponseEntity<List<User>> getUsersByAnswerProvided(@PathVariable("answerProvided") String answerProvided) {
        List<User> users = userService.findUserByAnswerProvided(answerProvided);
        return ResponseEntity.ok(users);
    }

    @SneakyThrows
    @GetMapping("/users/comments-added/{content}")
    public ResponseEntity<List<User>> getUserByCommentsAdded(@PathVariable("content") String content) {
        List<User> users = userService.findUserByCommentsAdded(content);
        return ResponseEntity.ok(users);
    }
}
