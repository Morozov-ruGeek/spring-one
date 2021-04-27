package ru.geekbrains.spring.one.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


@Configuration
public class HibernateUtils {

    @Bean
    public SessionFactory factory(){
        try {
            SessionFactory factory = new org.hibernate.cfg.Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            prepareDate(factory);
            return factory;
        } catch (HibernateException e){
            throw new RuntimeException(e);
        }
    }

    public void prepareDate(SessionFactory factory){
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

}
