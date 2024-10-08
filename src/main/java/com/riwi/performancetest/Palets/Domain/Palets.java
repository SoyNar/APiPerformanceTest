package com.riwi.performancetest.Palets.Domain;

import com.riwi.performancetest.Users.Domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
