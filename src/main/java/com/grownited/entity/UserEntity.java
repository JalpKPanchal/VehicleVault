package com.grownited.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String gender;
    private String contactNum;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    // 🔹 OTP Fields
    private String otp;                 // Stores the generated OTP
    private LocalDateTime otpExpiry;    // OTP expiration time

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = AccountStatus.ACTIVE; // Default status
    }

    /**
     * Generates an OTP and sets its expiry time.
     */
    public void generateOtp() {
        this.otp = String.valueOf(100000 + (int) (Math.random() * 900000)); // Generates a 6-digit OTP
        this.otpExpiry = LocalDateTime.now().plusMinutes(5); // OTP valid for 5 minutes
    }

    /**
     * Validates if the provided OTP is correct and not expired.
     */
    public boolean isOtpValid(String inputOtp) {
        return this.otp != null && this.otp.equals(inputOtp) && this.otpExpiry.isAfter(LocalDateTime.now());
    }

    public enum Role {
        ADMIN, USER, TECHNICIAN
    }

    public enum AccountStatus {
        ACTIVE, DISABLED
    }
}
