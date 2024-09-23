package com.example.demo.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RandomController {

    @GetMapping("/api/random")
    public String generateRandomNumber() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 501));
    }
}
