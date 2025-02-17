package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areaId;

    @Column(nullable = false, unique = true)
    private String areaName;

    @ManyToOne
    @JoinColumn(name = "cityId", nullable = false)
    private CityEntity city;
}
