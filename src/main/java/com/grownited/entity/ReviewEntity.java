package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private int rating;

    @Temporal(TemporalType.DATE)
    private Date reviewDate;

    @Column(columnDefinition = "TEXT")
    private String reviewText;

    @Column(columnDefinition = "TEXT")
    private String anyExtraComment;
}
