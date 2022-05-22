package org.softuni.workshop_pathfinder.service;

import org.softuni.workshop_pathfinder.model.entity.Category;
import org.softuni.workshop_pathfinder.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    Category findCategoryByName(CategoryNameEnum categoryNameEnum);
}
