package org.softuni.workshop_pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity{

    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private User recipient;
}
