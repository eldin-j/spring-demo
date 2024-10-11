package com.example.demo.lab3.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    private final Map<Long, User> userDatabase = new HashMap<>();

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
