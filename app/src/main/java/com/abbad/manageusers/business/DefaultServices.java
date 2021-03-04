package com.abbad.manageusers.business;

import com.abbad.manageusers.dao.UserDao;
import com.abbad.manageusers.model.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultServices implements  Services {
    private UserDao userDao;
    public DefaultServices(UserDao userDao)
    {
        this.userDao=userDao;
    }
    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public List<User> getUsersSortedByName() {
        List<User> users=new ArrayList<>(userDao.getUsers());
        List<User> sortedUsers=new ArrayList<>();
        while(users.size()!=0)
        {
            int posMin=0;
            for (int i=1;i<users.size();i++)
            {
                if(users.get(posMin).getName().
                        compareTo(users.get(i).getName())>0)
                    posMin=i;
            }
            User tmp=users.get(posMin);
            sortedUsers.add(tmp);
            users.remove(tmp);
        }
        return sortedUsers;
    }
}
