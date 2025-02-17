package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(length = 50)
    private String variant;

    private Double mileage;

    @Column(nullable = false, length = 20)
    private String fuelType;

    @Column(nullable = false, length = 20)
    private String transmissionType;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(length = 30)
    private String color;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, length = 20)
    private String status;

    @Temporal(TemporalType.DATE)
    private Date listingDate;

    @Column(nullable = false, length = 20, unique = true)
    private String registrationNum;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity owner;

    @ManyToOne
    @JoinColumn(name = "cityId", nullable = false)
    private CityEntity city;

    @ManyToOne
    @JoinColumn(name = "areaId", nullable = false)
    private AreaEntity area;

    @ManyToOne
    @JoinColumn(name = "stateId", nullable = false)
    private StateEntity state;

    private Integer registrationYear;
    
    @Column(length = 50)
    private String insurance;

    private Integer seats;
    private Integer kmsDriven;

    @Column(length = 50)
    private String RTO;

    @Column(length = 50)
    private String ownership;

    @Column(length = 20)
    private String engineDisplacement;

    private Integer noOfAirBags;
}
