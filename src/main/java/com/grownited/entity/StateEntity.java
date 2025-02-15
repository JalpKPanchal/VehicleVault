package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "states")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;

    @Column(nullable = false, unique = true)
    private String stateName;
}
