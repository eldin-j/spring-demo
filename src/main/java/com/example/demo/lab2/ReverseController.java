package com.example.demo.lab2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// example http://localhost:8080/api/reverse?s=sendmehome

@RestController
public class ReverseController {

    @GetMapping("/api/reverse")
    public String reverseString(@RequestParam(value = "s") String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
