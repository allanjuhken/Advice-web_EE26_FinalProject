package project.adviceweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.adviceweb.service.*;

@Controller
public class AdminController {
    private final UserService userService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final CategoryService categoryService;
    private final CommentService commentService;

    public AdminController(UserService userService, QuestionService questionService, AnswerService answerService, CategoryService categoryService, CommentService commentService) {
        this.userService = userService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.categoryService = categoryService;
        this.commentService = commentService;
    }
}
