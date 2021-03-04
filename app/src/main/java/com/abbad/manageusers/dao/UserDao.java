package com.abbad.manageusers.dao;

import com.abbad.manageusers.model.User;

import java.util.List;

public interface UserDao {
    //CRUD
    public User addUser(User user);
    public User updateUser(User user);
    public boolean deleteUser(int id);
    public User getUser(int id);
    public List<User> getUsers();
}