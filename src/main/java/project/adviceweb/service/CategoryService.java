package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.dto.CategoryDto;
import project.adviceweb.model.Category;
import project.adviceweb.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategoriesByType(String type) {
        return categoryRepository.findAllCategories(type);
    }
}
