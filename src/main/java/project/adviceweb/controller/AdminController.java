package project.adviceweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.adviceweb.dto.CategoryDto;
import project.adviceweb.dto.UserDto;
import project.adviceweb.exception.CategoryNotFoundException;
import project.adviceweb.model.Category;
import project.adviceweb.model.Comment;
import project.adviceweb.model.User;
import project.adviceweb.service.*;

import java.util.List;

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

    @GetMapping("/user")
    public String showRegisterPage(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "register-user";
    }

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    

    @GetMapping("/admin/user/create")
    public String showCreateUserForm(ModelMap modelMap) {
        UserDto userDto = new UserDto();
        modelMap.addAttribute("userDto", userDto);
        return "create-user";
    }

    @PostMapping("/admin/user/users")
    public String createUser(@ModelAttribute("userDto") UserDto userDto) {
        userService.save(userDto.getId(), userDto);
        return "redirect:/admin/users";
    }
}
