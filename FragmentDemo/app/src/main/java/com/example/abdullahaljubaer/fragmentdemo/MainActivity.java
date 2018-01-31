package com.example.abdullahaljubaer.fragmentdemo;

import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.add( R.id.fragment_container, loginFragment);
        fragmentTransaction.commit();
        //registerButton = (Button) findViewById(R.id.button_register);
        //registerButton.setOnClickListener((View.OnClickListener) this);

    }
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RegisterFragment registerFragment = new RegisterFragment();
        fragmentTransaction.replace( R.id.fragment_container, registerFragment);
        fragmentTransaction.commit();
    }
}
