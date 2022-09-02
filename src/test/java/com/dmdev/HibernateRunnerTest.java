package com.dmdev;

import com.dmdev.entity.BirthDay;
import com.dmdev.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HibernateRunnerTest {

    @Test
    void checkReflectionAPI() {
        User user = User.builder()
                .username("Alex")
                .firstname("Oleksandr")
                .lastname("Nikolaichuk")
                .birthDate(new BirthDay(LocalDate.of(1978, 5, 7)))
                .build();
        String sql = "insert into  users (age, birthday, firstname, lastname, username)";
    }
}