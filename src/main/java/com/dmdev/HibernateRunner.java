package com.dmdev;

import com.dmdev.converter.BirthDayConverter;
import com.dmdev.entity.BirthDay;
import com.dmdev.entity.Role;
import com.dmdev.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.addAttributeConverter(new BirthDayConverter(), true);
        configuration.configure();


        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User user = User.builder()
                    .username("Alex")
                    .firstname("Oleksandr")
                    .lastname("Nikolaichuk")
                    .birthDate(new BirthDay(LocalDate.of(1978, 5, 7)))
                    .role(Role.USER)
                    .build();
            session.persist(user);
            user.setFirstname("Sasha");
            session.getTransaction().commit();
        }
    }
}
