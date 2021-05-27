package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment {
    User user;
    TextView userInfo;
    Button btnUserEdit;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //int position = getActivity().getIntent().getIntExtra("position",1);
        int position = getArguments().getInt("position");
        user = Users.get(getActivity()).getUserList().get(position);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user, viewGroup, false);
        int position = getArguments().getInt("position");
        userInfo = view.findViewById(R.id.userInfo);
        btnUserEdit = view.findViewById(R.id.editUserBtn);
        userInfo.setText(user.getUserName()+" "+user.getUserLastName()+"\n"+user.getPhone());
        btnUserEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditUserActivity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
        return view;
    }
}
