package com.example.demo.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// example http://localhost:8080/api/fibonacci?n=10

@RestController
public class FibonacciController {

    @GetMapping("/api/fibonacci")
    public String getFibonacciNumber(@RequestParam int n) {
        int fibonacciNumber = calculateFibonacci(n);

        return String.valueOf(fibonacciNumber);
    }


    private int calculateFibonacci(int n) {
        if (n <= 1) return n;
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
