package com.dmdev.entity;

import com.dmdev.converter.BirthDayConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;

    @Column(name = "birthday")
    @Convert(converter = BirthDayConverter.class)
    private BirthDay birthDate;

    @Enumerated(EnumType.STRING)
    private Role role;

}
