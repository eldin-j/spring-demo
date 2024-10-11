package com.example.demo.lab4.postgresql;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lab4/psql-users")
public class UserControllerPSQL {

    private final UserRepositoryPSQL userRepositoryPSQL;

    public UserControllerPSQL(UserRepositoryPSQL userRepositoryPSQL) {
        this.userRepositoryPSQL = userRepositoryPSQL;
    }

    @PostMapping
    public ResponseEntity<UserPSQL> addUserPSQL(@Valid @RequestBody UserPSQL newUser) {
        UserPSQL savedUser = userRepositoryPSQL.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateResultPSQL> updateUserPSQL(@PathVariable Long id, @RequestBody UserPSQL updatedUser) {
        Optional<UserPSQL> optionalUser = userRepositoryPSQL.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        UserPSQL existingUser = optionalUser.get();
        existingUser.setName(updatedUser.getName());
        existingUser.setAge(updatedUser.getAge());
        userRepositoryPSQL.save(existingUser);

        UpdateResultPSQL result = new UpdateResultPSQL(true, "User updated successfully", existingUser);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResultPSQL> deleteUserPSQL(@PathVariable Long id) {
        Optional<UserPSQL> optionalUser = userRepositoryPSQL.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userRepositoryPSQL.deleteById(id);
        DeleteResultPSQL result = new DeleteResultPSQL(true, "User deleted successfully");
        return ResponseEntity.ok(result);
    }
}
