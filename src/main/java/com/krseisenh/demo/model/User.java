package com.krseisenh.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class User {
    @Id
    public ObjectId _id;
    @NotBlank
    public String username;
    public String password;
    public String token;

    public User(ObjectId _id, String username, String password, String token) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
