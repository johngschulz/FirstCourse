package com.firstcourse.FirstCourse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private int id;

    private String role;

    @ManyToMany
    private List<User> users;

}
