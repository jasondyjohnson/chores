package com.jasondyjohnson;

import com.jasondyjohnson.domain.ChoreReward;
import com.jasondyjohnson.domain.User;
import com.jasondyjohnson.domain.UserToChoreReward;
import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * Created by Jason on 2/20/2016.
 */
@SpringBootApplication
@Slf4j
public class ChoresApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChoresApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository, ChoreRewardRepository choreRepository) {
        return (args) -> {
            try {
                Class<?> clazz = Class.forName("com.jasondyjohnson.InitChoresApplication");
                InitChoresApplication.devInitDatabase(userRepository, choreRepository);
            } catch (ClassNotFoundException e) {
                log.info("Could not find chores init");
            }

        };
    }

}
