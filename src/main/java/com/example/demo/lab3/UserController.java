package com.example.demo.lab3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    // Имитация базы данных пользователей
    private Map<Long, User> userDatabase = new HashMap<>();

    @PutMapping("/{id}")
    public ResponseEntity<UpdateResult> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        if (!userDatabase.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = userDatabase.get(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());
        userDatabase.put(id, existingUser);

        UpdateResult result = new UpdateResult(true, "User updated successfully", existingUser);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResult> deleteUser(@PathVariable Long id) {
        if (!userDatabase.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        User deletedUser = userDatabase.remove(id);
        DeleteResult result = new DeleteResult(true, "User deleted successfully", deletedUser);
        return ResponseEntity.ok(result);
    }

    // Вспомогательный метод для добавления пользователя
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        long newId = userDatabase.size() + 1;
        newUser.setId(newId);
        userDatabase.put(newId, newUser);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@Valid @RequestBody ValidatedUser user) {
        // Если мы дошли до этой точки, значит валидация прошла успешно
        return ResponseEntity.ok("User data is valid");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
}

class User {
    private Long id;
    private String name;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class UpdateResult {
    private boolean success;
    private String message;
    private User updatedUser;

    public UpdateResult(boolean success, String message, User updatedUser) {
        this.success = success;
        this.message = message;
        this.updatedUser = updatedUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUpdatedUser() {
        return updatedUser;
    }
}

class DeleteResult {
    private boolean success;
    private String message;
    private User deletedUser;

    public DeleteResult(boolean success, String message, User deletedUser) {
        this.success = success;
        this.message = message;
        this.deletedUser = deletedUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getDeletedUser() {
        return deletedUser;
    }
}

class ValidatedUser {
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
