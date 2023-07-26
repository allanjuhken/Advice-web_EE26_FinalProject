package project.adviceweb.controller;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.adviceweb.model.User;
import project.adviceweb.service.UserService;

import java.util.List;

@Controller
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
        List<User> users = userService.findByQuestionAsked(content);
        return ResponseEntity.ok(users);
    }

    @SneakyThrows
    @GetMapping("/users/answers-provided/{content}")
    public ResponseEntity<List<User>> getUsersByAnswersProvided(@PathVariable("content") String content) {
        List<User> users = userService.findByAnswersProvided(content);
        return ResponseEntity.ok(users);
    }

    @SneakyThrows
    @GetMapping("/users/comments-added/{content}")
    public ResponseEntity<List<User>> getUsersByCommentsAdded(@PathVariable("content") String content) {
        List<User> users = userService.findByCommentsAdded(content);
        return ResponseEntity.ok(users);
    }
}
