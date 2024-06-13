package com.example.lab7_8.model;

import com.example.lab7_8.model.dao.UserDAO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {
    private int id;
    private @NotEmpty(
            message = "Имя пользователя не может быть пустым"
    ) @Size(
            min = 4,
            max = 15,
            message = "Длина имени пользователя должна быть от 4 до 15 символов"
    ) String name;
    private String email;
    private @NotEmpty(
            message = "Пароль  не может быть пустым"
    ) @Size(
            min = 4,
            max = 30,
            message = "Длина пароля  должна быть от 4 до 30 символов"
    ) String password;
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
        this.id = UserDAO.getUsers_count();
        UserDAO.setUsers_count(UserDAO.getUsers_count() + 1);

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}