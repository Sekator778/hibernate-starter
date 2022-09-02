package com.dmdev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BirthDay {
    private LocalDate birthday;

    public long getAge() {
        return ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }



}
