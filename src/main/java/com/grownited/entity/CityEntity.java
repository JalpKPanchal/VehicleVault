package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    @Column(nullable = false, unique = true)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    private StateEntity state;
}
