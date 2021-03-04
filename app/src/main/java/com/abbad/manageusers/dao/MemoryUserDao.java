package com.abbad.manageusers.dao;

import com.abbad.manageusers.model.User;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserDao implements UserDao{
    private List<User> users;
    public MemoryUserDao()
    {
        users=new ArrayList<>();
        users.add(new User(1,
                "mehdi.tmimi",
                "tmimi",
                "mehditmimi@live.fr"));
        users.add(new User(2,
                "omar.filali",
                "filali",
                "omarfilali@live.fr"));
    }

    @Override
    public User addUser(User user) {
        //verification d unicite
        for(User u:users)
            if(u.getId()==user.getId())
                return null;

        users.add(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        for(User u:users)
            if(u.getId()==user.getId()) {
                u.setName(user.getName());
                u.setUserName(user.getUserName());
                u.setEmail(user.getEmail());
                return user;
            }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        for(User u:users)
            if(u.getId()==id)
            {
                users.remove(u);
                return true;
            }
        return false;
    }

    @Override
    public User getUser(int id) {
        for(User u:users)
            if(u.getId()==id)
                return u;

        return null;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}