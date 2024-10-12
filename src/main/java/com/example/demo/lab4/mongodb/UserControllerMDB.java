package com.example.demo.lab4.mongodb;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lab4/mdb-users")
public class UserControllerMDB {

    private final UserRepositoryMDB userRepositoryMDB;

    public UserControllerMDB(UserRepositoryMDB userRepositoryMDB) {
        this.userRepositoryMDB = userRepositoryMDB;
    }

    @PostMapping
    public ResponseEntity<UserMDB> addUserMDB(@Valid @RequestBody UserMDB newUser) {
        UserMDB savedUser = userRepositoryMDB.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public List<UserMDB> getAllUsersMDB() {
        return userRepositoryMDB.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMDB> getUserByIdMDB(@PathVariable String id) {
        Optional<UserMDB> user = userRepositoryMDB.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserMDB> updateUserMDB(@PathVariable String id, @Valid @RequestBody UserMDB userDetails) {
        Optional<UserMDB> userOptional = userRepositoryMDB.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UserMDB existingUser = userOptional.get();
        existingUser.setName(userDetails.getName());
        existingUser.setAge(userDetails.getAge());

        UserMDB updatedUser = userRepositoryMDB.save(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserMDB(@PathVariable String id) {
        Optional<UserMDB> user = userRepositoryMDB.findById(id);
        if (user.isPresent()) {
            userRepositoryMDB.delete(user.get());
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
