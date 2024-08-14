package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.todolist")
public class SpringBootProject3Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProject3Application.class, args);
    }
}


//http://localhost:8080/tasks
//url to run project