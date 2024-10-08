package com.riwi.performancetest.Palets.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "loadEntity")
public class LoadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  int weight;

    @Column(nullable = false)
    private int dimensions;

    @Column(nullable = false)
    private StateLoad stateLoad;

    @ManyToOne
    @JoinColumn(name = "palets_id")
    private Palets palets;

}
