package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private InsuranceType insuranceType;
    
    public enum InsuranceType {
        THIRD_PARTY,
        FULL,
        COMPREHENSIVE
    }
}
