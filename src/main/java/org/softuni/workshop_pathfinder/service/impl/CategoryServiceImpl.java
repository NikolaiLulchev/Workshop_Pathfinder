package org.softuni.workshop_pathfinder.service.impl;

import org.softuni.workshop_pathfinder.model.entity.Category;
import org.softuni.workshop_pathfinder.model.entity.enums.CategoryNameEnum;
import org.softuni.workshop_pathfinder.repository.CategoryRepository;
import org.softuni.workshop_pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category findCategoryByName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum).orElse(null);
    }
}
