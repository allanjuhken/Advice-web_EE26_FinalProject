package project.adviceweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import project.adviceweb.dto.AnswerDto;
import project.adviceweb.dto.CategoryDto;
import project.adviceweb.dto.QuestionDto;
import project.adviceweb.dto.UserDto;
import project.adviceweb.exception.CategoryNotFoundException;
import project.adviceweb.exception.QuestionNotFoundException;
import project.adviceweb.model.*;
import project.adviceweb.service.*;

import java.util.ArrayList;
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

    @GetMapping("/admin/register-user")
    public String showRegisterPage(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "register-user";
    }

    @PostMapping("/admin/register")
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

    @GetMapping("/")
    public String index(Model model) {
        List<Question> latestQuestions = questionService.getMostRecentQuestions();
        List<Question> popularQuestions = questionService.getPopularQuestions();

        model.addAttribute("latestQuestions", latestQuestions);
        model.addAttribute("popularQuestions", popularQuestions);

        return "index";
    }

    @GetMapping("/admin/categories")
    public String getCategories(final ModelMap modelMap) {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();
        modelMap.addAttribute("categoryDtoList", categoryDtoList);
        return "categories";
    }

    @GetMapping("/admin/category/create")
    public String showCreateCategoryForm(ModelMap modelMap) {
        Category category = new Category();
        modelMap.addAttribute("category", category);
        return "create-category";
    }

    @PostMapping("/admin/category")
    public String createCategory(@ModelAttribute("category") Category category) {
        category.setCategoryId(category.getCategoryId());
        categoryService.save(category);
        return "redirect:/admin/category/create";
    }

    @GetMapping("/admin/comment/create")
    public String showCreateCommentForm(ModelMap modelMap) {
        Comment comment = new Comment();
        modelMap.addAttribute("comment", comment);
        return "create-comment";
    }

    @PostMapping("/admin/comment")
    public String createComment(@ModelAttribute("comment")
                                Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/";
    }

    @GetMapping("/admin/question/create")
    public String showCreateQuestionForm(ModelMap modelMap) {
        Question question = new Question();
        modelMap.addAttribute("question", question);
        return "create-question";
    }

    @PostMapping("/admin/question")
    public String createQuestion(@ModelAttribute("question")
                                     Question question) {
        questionService.save(question);
        return "redirect:/";
    }

    @GetMapping("/admin/answer/create")
    public String showCreateAnswerForm(ModelMap modelMap) {
        Answer answer = new Answer();
        modelMap.addAttribute("answer", answer);
        return "create-answer";
    }

    @PostMapping("/admin/answer")
    public String createAnswer(@ModelAttribute("answer") Answer answer) {
        answerService.save(answer);
        return "redirect:/";
    }

    @GetMapping("/admin/category-computer/create")
    public String showCreateCategoryComputerForm(ModelMap modelMap) {
        Category category = new Category();
        modelMap.addAttribute("category", category);
        return "category-computer";
    }

    @PostMapping("/admin/category-computer")
    public String createCategoryComputer(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/admin/category-cooking/create")
    public String showCreateCategoryCookingForm(ModelMap modelMap) {
        Category category = new Category();
        modelMap.addAttribute("category", category);
        return "category-cooking";
    }

    @PostMapping("/admin/category-cooking")
    public String createCategoryCooking(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/admin/category-health/create")
    public String showCreateCategoryHealthForm(ModelMap modelMap) {
        Category category = new Category();
        modelMap.addAttribute("category", category);
        return "category-health";
    }

    @PostMapping("/admin/category-health")
    public String createCategoryHealth(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/category/{categoryName}")
    public String browseQuestionByCategory(@PathVariable String categoryName, Model model) throws QuestionNotFoundException {
        List<Question> questions = questionService.findQuestionByCategory(categoryName);
        model.addAttribute("questions", questions);
        return "questions";
    }

    @GetMapping("/question/{questionId}")
    public String viewQuestion(@PathVariable Long questionId, Model model) throws QuestionNotFoundException {
        Question question = questionService.findQuestionByQuestionId(questionId);
        model.addAttribute("question", question);
        return "create-question";
    }

    @GetMapping("/admin/question/most-recent")
    public String showMostRecentQuestions(Model model) {
        List<Question> mostRecentQuestions = questionService.getMostRecentQuestions();
        model.addAttribute("questions", mostRecentQuestions);
        return "questions";
    }

    @GetMapping("/admin/question/popular")
    public String showPopularQuestions(Model model) {
        List<Question> popularQuestions = questionService.getPopularQuestions();
        model.addAttribute("questions", popularQuestions);
        return "questions";
    }


}
