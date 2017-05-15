package com.digitcreativestudio.auditmobil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.digitcreativestudio.auditmobil.utilities.SessionPreference;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private SessionPreference sessionPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sessionPreference = new SessionPreference(this);

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.login_button){
            sessionPreference.createLoginSession();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        }
    }
}
