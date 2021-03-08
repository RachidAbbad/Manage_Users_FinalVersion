package com.abbad.manageusers.dao;

import com.abbad.manageusers.model.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RealmUserDao implements UserDao {
    private Realm myRealm;
    private RealmAsyncTask realmTask;
    private RealmResults<User> realmResults;
    private boolean success = true;
    @Override
    public User addUser(User user) {
        realmTask = myRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObject(User.class, user.getId());
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                success = false;
                error.printStackTrace();
            }
        });

        return success ? user : null;
    }

    @Override
    public User updateUser(User user) {
        RealmResults<User> results = myRealm.where(User.class).equalTo("id", user.getId()).findAll();
        myRealm.beginTransaction();
        for(User u : results){
            u.setName(user.getName());
            u.setUserName(user.getUserName());
            u.setEmail(user.getEmail());
        }
        myRealm.commitTransaction();
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        myRealm.beginTransaction();
        RealmQuery query = myRealm.where(User.class);
        RealmResults results = query.findAll();
        results.remove(id);
        myRealm.commitTransaction();
        return true;
    }

    @Override
    public User getUser(int id) {
        return myRealm.where(User.class).equalTo("id", id).findFirst();
    }

    @Override
    public List<User> getUsers() {
        realmResults = myRealm.where(User.class).findAll();
        return myRealm.copyFromRealm(realmResults);
    }
}
