package com.abbad.manageusers.presentation.controllers;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.abbad.manageusers.R;
import com.abbad.manageusers.Utils.CustomUserAdapter;
import com.abbad.manageusers.Utils.MyContext;
import com.abbad.manageusers.presentation.actions.Delete_Update_Event;
import com.abbad.manageusers.presentation.actions.SwipeToDeleteEvent;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity {

    //private static MainActivity instance;
    private AppCompatButton btnAddUser;
    private SwipeMenuListView listView;
    private MyContext context;
    private SwipeToDeleteEvent eventSwipe;
    private Delete_Update_Event eventDeleteUpdate;
    private AddNewUser addNewUser;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instance = this;
        realm = Realm.getDefaultInstance();
        context= (MyContext) getApplicationContext();
        listView = findViewById(R.id.list_view);
        btnAddUser = findViewById(R.id.addUserBtn);
        //Set Adapter
        CustomUserAdapter customAdapter=new CustomUserAdapter(context);
        listView.setAdapter(customAdapter);
        //Swipe event
        eventSwipe = new SwipeToDeleteEvent(context);
        listView.setMenuCreator(eventSwipe);
        //Delete Or Update Item Click :
        eventDeleteUpdate = new Delete_Update_Event(context,customAdapter,getSupportFragmentManager());
        listView.setOnMenuItemClickListener(eventDeleteUpdate);
        //Open BottomSheetFragment to add new User :

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser = new AddNewUser(context,customAdapter);
                addNewUser.show(getSupportFragmentManager(),"AddUserBottomFragement");
            }
        });

        /*public static MainActivity getInstance(){
            return
        }*/
    }
}