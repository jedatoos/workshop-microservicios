package com.example.pruebamongo.service;


import com.example.pruebamongo.Repository.UserRepository;
import com.example.pruebamongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Crear un nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Leer todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Leer un usuario por ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Actualizar un usuario
    public User updateUser(String id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    // Eliminar un usuario
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
