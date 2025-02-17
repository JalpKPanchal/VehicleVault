package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "inquiry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryId;

    @ManyToOne
    @JoinColumn(name = "carId", nullable = false)
    private CarEntity car;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @Temporal(TemporalType.DATE)
    private Date inquiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryStatus status; // OPEN or CLOSE

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    // Enum for inquiry status (open or close)
    public enum InquiryStatus {
        OPEN, CLOSE
    }
}
