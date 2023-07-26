package project.adviceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.adviceweb.model.Category;
import project.adviceweb.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/{type}")
    public List<Category> getAllCategoriesByType(@PathVariable String type) {
        return categoryService.findAllCategoriesByType(type);
    }
}
