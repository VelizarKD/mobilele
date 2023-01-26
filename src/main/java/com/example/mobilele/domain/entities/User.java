package com.example.mobilele.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.util.Date;
import java.util.List;
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Boolean isActive;
    @OneToMany
    private List<UserRole> role;
    @Column
    private String imageUrl;
    @Column
    private Date created;
    @Column
    private Date modified;
}
