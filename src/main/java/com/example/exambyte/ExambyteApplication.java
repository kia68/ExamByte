package com.example.exambyte;

import com.example.exambyte.test.Aufgaben;
import com.example.exambyte.test.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class ExambyteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExambyteApplication.class, args);
    }

}
