package com.example.demo.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// example http://localhost:8080/api/generate?n=10

@RestController
public class GeneratorController {

    @GetMapping("/api/generate")
    public String generateNumbers(@RequestParam int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
    }
}
