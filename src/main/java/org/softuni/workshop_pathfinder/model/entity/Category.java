package org.softuni.workshop_pathfinder.model.entity;

import org.softuni.workshop_pathfinder.model.entity.BaseEntity;
import org.softuni.workshop_pathfinder.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryNameEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
