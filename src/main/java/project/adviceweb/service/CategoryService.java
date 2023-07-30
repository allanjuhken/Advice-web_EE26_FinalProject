package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.dto.CategoryDto;
import project.adviceweb.exception.CategoryNotFoundException;
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

    public Category findCategoryByName(String name)
            throws CategoryNotFoundException {
        Category category = categoryRepository.findCategoryByName(name);
        if (category == null)
            throw new CategoryNotFoundException("Category not found", 2);
        return category;
    }

    public List<Category> findAllCategoriesByType(String type) {
        return categoryRepository.findAllCategoriesByType(type);
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(category.getId());
            categoryDto.setName(category.getName());
            categoryDto.setType(category.getType());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }


    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = toCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return toCategoryDto(savedCategory);
    }

    private Category toCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setType(categoryDto.getType());
        return category;
    }

    private CategoryDto toCategoryDto(Category savedCategory) {
        CategoryDto savedCategoryDto = new CategoryDto();
        savedCategoryDto.setId(savedCategory.getId());
        savedCategoryDto.setName(savedCategory.getName());
        savedCategoryDto.setType(savedCategory.getType());
        return savedCategoryDto;
    }
}
