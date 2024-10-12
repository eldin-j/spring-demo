package com.example.demo.lab4.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryMDB extends MongoRepository<UserMDB, String> {
}
