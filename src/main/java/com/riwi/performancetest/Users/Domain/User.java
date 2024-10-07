package com.riwi.performancetest.Users.Domain;

import com.riwi.performancetest.Palets.Domain.Palets;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    @Email
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Palets> palest;
}
