package com.abbad.manageusers.presentation.controllers;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;

import com.abbad.manageusers.R;
import com.abbad.manageusers.Utils.CustomUserAdapter;
import com.abbad.manageusers.Utils.MyContext;
import com.abbad.manageusers.model.User;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UpdateUser extends BottomSheetDialogFragment {
    private EditText name;
    private EditText userName;
    private EditText email;
    private AppCompatButton btnSave;
    private MyContext context;
    private CustomUserAdapter adapter;
    private User user;

    public UpdateUser(MyContext context, CustomUserAdapter adapter,User user) {
        this.context = context;
        this.adapter = adapter;
        this.user = user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_user_layout, container, false);
        //Initialise EditTexts & Button :
        name = view.findViewById(R.id.name);
        userName = view.findViewById(R.id.userName);
        email = view.findViewById(R.id.email);
        btnSave = view.findViewById(R.id.saveUser);
        //Set Old Values :
        name.setText(user.getName());
        userName.setText(user.getUserName());
        email.setText(user.getEmail());
        //Add On Click Listener To Btn :
        btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(name.getText().length()!=0 && userName.getText().toString().length()!=0 || email.getText().toString().length()!=0){
                    User updatedUser = new User(user.getId(),userName.getText().toString(),name.getText().toString(),email.getText().toString());
                    context.getServices().updateUser(updatedUser);
                    adapter.notifyDataSetChanged();
                }
                dismiss();
            }
        });

        return view;
    }
}
