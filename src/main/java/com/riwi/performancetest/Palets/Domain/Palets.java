package com.riwi.performancetest.Palets.Domain;

import com.riwi.performancetest.Users.Domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "palets")
public class Palets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "palets", cascade = CascadeType.ALL)
    private List<LoadEntity> loadEntity;
}
