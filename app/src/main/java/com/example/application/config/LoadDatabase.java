package com.example.application.config;

import com.example.application.entity.Subject;
import com.example.application.entity.User;
import com.example.application.repository.SubjectRepository;
import com.example.application.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, SubjectRepository subjectRepository) {

        return args -> {
            List<User> users = userRepository.findAll();
//            Если уже есть данные в базе, то второй раз создавать пользователей не надо.
            if(!users.isEmpty()) {
                return;
            }
            User userA = new User();
            userA.setUsername("admin");
            //            Пароль должен храниться в хэшированов виде
            userA.setPassword("admin");
            userRepository.save(userA);

            Subject subject = new Subject();
            subject.setName("subjectA");
            subject.setUser(userA);
            subjectRepository.save(subject);

            subject = new Subject();
            subject.setName("subjectB");
            subject.setUser(userA);
            subjectRepository.save(subject);


            User userB = new User();
            userB.setUsername("demo");
            userB.setPassword("demo");
            userRepository.save(userB);

            subject = new Subject();
            subject.setName("subjectC");
            subject.setUser(userB);
            subjectRepository.save(subject);

            subject = new Subject();
            subject.setName("subjectD");
            subject.setUser(userB);
            subjectRepository.save(subject);


        };
    }
}
