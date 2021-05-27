package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.UUID;


public class EditUserActivity extends AppCompatActivity {
    Button insertUserBtn2;
    EditText editTextName2;
    EditText editTextLastName2;
    EditText editTextPhone2;
    User user;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Bundle arguments = getIntent().getExtras();
        int position = (int) arguments.get("position");
        users = Users.get(this).getUserList();

        insertUserBtn2 = findViewById(R.id.insertUserBtn2);
        editTextName2 = findViewById(R.id.editTextName2);
        editTextLastName2 = findViewById(R.id.editTextLastName2);
        editTextPhone2 = findViewById(R.id.editTextPhone2);

        insertUserBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                user = users.get(position);
                user.setUserName(editTextName2.getText().toString());
                user.setUserLastName(editTextLastName2.getText().toString());
                user.setPhone(editTextPhone2.getText().toString());



                onBackPressed();
            }
        });
    }
}