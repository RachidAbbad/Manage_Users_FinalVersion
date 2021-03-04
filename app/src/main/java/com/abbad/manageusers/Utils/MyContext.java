package com.abbad.manageusers.Utils;


import android.app.Application;

import com.abbad.manageusers.business.DefaultServices;
import com.abbad.manageusers.business.Services;
import com.abbad.manageusers.dao.MemoryUserDao;

public class MyContext  extends Application {

    private Services services;
    public MyContext()
    {
        this.services=new DefaultServices(new MemoryUserDao());
    }

    public Services getServices() {
        return services;
    }
}