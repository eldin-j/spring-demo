package com.example.demo.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// example http://localhost:8080/api/guesser?n=10

@RestController
public class GuesserController {

    private final int targetNumber = 8; // right number

    @GetMapping("/api/guesser")
    public String guessNumber(@RequestParam(value = "n") int guess) {
        if (guess < targetNumber) {
            return "The right number is bigger.";
        } else if (guess > targetNumber) {
            return "The right number is smaller.";
        } else {
            return "You got it right!";
        }
    }
}
