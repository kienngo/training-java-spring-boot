package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "m_user")
public class User {
    @Id
    @Column(name = "id")
    UUID id;

    @NotBlank
    @Column(name = "username", nullable = false, unique = true)
    String username;

    @NotBlank
    @Column(name = "email", nullable = false, unique = true)
    String email;

    @NotBlank
    @Size(max = 120)
    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "birthday")
    LocalDate birthday;

    @NotBlank
    @Size(max = 40)
    @Column(name = "fullname", nullable = false)
    String fullName;
}
