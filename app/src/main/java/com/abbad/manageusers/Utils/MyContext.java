package com.abbad.manageusers.Utils;


import android.app.Application;

import com.abbad.manageusers.business.DefaultServices;
import com.abbad.manageusers.business.Services;
import com.abbad.manageusers.dao.MemoryUserDao;
import com.abbad.manageusers.dao.RealmUserDao;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyContext  extends Application {

    private Services services;
    public MyContext()
    {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().name("users_realm").build();
        Realm.setDefaultConfiguration(configuration);
        this.services=new DefaultServices(new RealmUserDao());

    }

    public Services getServices() {
        return services;
    }
}