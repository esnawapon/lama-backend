package com.krseisenh.demo.controller;

import com.krseisenh.demo.exception.ValidationException;
import com.krseisenh.demo.model.User;
import com.krseisenh.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;

@RequestMapping()
@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    // private HashData hashData = new HashData();

    @PostMapping("/api/v1/user")
    public Boolean create(@RequestBody User user) throws NoSuchAlgorithmException {
        String username = user.getUsername();
        if (repository.existsByUsername(username)) {

            throw new ValidationException("this $username already existed");

        }

        String password = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        // String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        user.set_id(ObjectId.get());
        user.setCreatedAt(new Date());
        user.setPassword(encodedPassword);
        repository.save(user);
        return true;
    }

    @GetMapping("/api/v1/user/{id}")
    public HashMap<String, Object> getUserById(@PathVariable("id") ObjectId id) {
        HashMap<String, Object> response = generateResponse(repository.findBy_id(id));
        return response;
    }

    @GetMapping("/api/v1/users")
    public HashMap<String, Object> getUserByUsername(@RequestParam("name") String name) {
        HashMap<String, Object> response = generateResponse(repository.findByUsername(name));
        return response;
    }

    @GetMapping("/api/v1/users/")
    public HashMap<String, Object> getAllUsers() {
        HashMap<String, Object> response = generateResponse(repository.findAll());
        return response;
    }

    private HashMap<String, Object> generateResponse(Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", data);
        map.put("message", "OK");
        return map;
    }
}
