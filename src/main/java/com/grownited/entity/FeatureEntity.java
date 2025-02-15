package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "features")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;

    @Column(nullable = false, unique = true, length = 100)
    private String featureName;
}
