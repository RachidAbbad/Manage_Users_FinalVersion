package com.abbad.manageusers.model;

public class User {
    private int id;
    private String userName;
    private String name;
    private String email;

    public User() {
    }

    public User(String userName, String name, String email) {
        this.userName = userName;
        this.name = name;
        this.email = email;
    }

    public User(int id, String userName, String name, String email) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}

