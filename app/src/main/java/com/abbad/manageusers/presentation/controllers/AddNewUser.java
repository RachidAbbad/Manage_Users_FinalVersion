package com.abbad.manageusers.presentation.controllers;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

import com.abbad.manageusers.R;
import com.abbad.manageusers.Utils.CustomUserAdapter;
import com.abbad.manageusers.Utils.MyContext;
import com.abbad.manageusers.model.User;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.time.LocalDate;
import java.util.zip.Inflater;

public class AddNewUser extends BottomSheetDialogFragment
{
    private EditText name;
    private EditText userName;
    private EditText email;
    private AppCompatButton btnSave;
    private MyContext context;
    private CustomUserAdapter adapter;

    public AddNewUser(MyContext context, CustomUserAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.add_user_layout, container, false);
        //Initialise EditTexts & Button :
        name = v.findViewById(R.id.name);
        userName = v.findViewById(R.id.userName);
        email = v.findViewById(R.id.email);
        btnSave = v.findViewById(R.id.saveUser);
        //Add On Click Listener To Btn :
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().length()!=0 && userName.getText().toString().length()!=0 || email.getText().toString().length()!=0){
                    User userModel = new User(userName.getText().toString(),name.getText().toString(),email.getText().toString());
                    userModel.setId(adapter.getCount()+1);
                    context.getServices().addUser(userModel);
                    adapter.notifyDataSetChanged();
                }
                dismiss();
            }
        });
        return v;
    }
}
