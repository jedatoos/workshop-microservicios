package com.example.pruebamongo.Repository;

import com.example.pruebamongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Métodos personalizados si es necesario
}