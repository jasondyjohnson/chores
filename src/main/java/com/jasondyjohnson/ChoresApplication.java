package com.jasondyjohnson;

import com.jasondyjohnson.repository.ChoreRewardRepository;
import com.jasondyjohnson.repository.PersonRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.lang.reflect.Method;

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
    public CommandLineRunner demo(PersonRepository personRepository, ChoreRewardRepository choreRepository) {
        return (args) -> {
            try {
                Class<?> clazz = Class.forName("com.jasondyjohnson.InitChoresApplication");
                Method m = clazz.getMethod("devInitDatabase", PersonRepository.class, ChoreRewardRepository.class);
                m.invoke(null, personRepository, choreRepository);
            } catch (ClassNotFoundException e) {
                log.info("Could not find chores init");
            }

        };
    }
}
