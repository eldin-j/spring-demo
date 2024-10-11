package com.example.demo.lab4.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryPSQL extends JpaRepository<UserPSQL, Long> {
}
