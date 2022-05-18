package org.softuni.workshop_pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

}
