package com.example.abdullahaljubaer.fragmentdemo;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ABDULLAH AL JUBAER on 15-07-17.
 */

public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText editTextName, editTextId, editTextPassword, editTextEmail;
    private String name, id, password, email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        editTextName = (EditText) view.findViewById(R.id.text_name);
        editTextId = (EditText) view.findViewById(R.id.text_id);
        editTextPassword = (EditText) view.findViewById(R.id.text_password);
        editTextEmail = (EditText) view.findViewById(R.id.text_email);
        Button b = view.findViewById(R.id.button_register1);
        b.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_register1){
            name = editTextName.getText().toString();
            id = editTextId.getText().toString();
            password = editTextPassword.getText().toString();
            email = editTextEmail.getText().toString();

            String method = "register";
            BackGroundTask backGroundTask = new BackGroundTask(v.getContext());
            backGroundTask.execute(method, name, id, password, email);
        }
    }
}
