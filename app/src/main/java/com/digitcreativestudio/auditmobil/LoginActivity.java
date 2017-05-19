package com.digitcreativestudio.auditmobil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.digitcreativestudio.auditmobil.entities.User;
import com.digitcreativestudio.auditmobil.utilities.SessionPreference;
import com.digitcreativestudio.auditmobil.view.ProgressDialog;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private SessionPreference sessionPreference;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sessionPreference = new SessionPreference(this);

        Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.login_button){
            String email = ((EditText) findViewById(R.id.email_edit_text)).getText().toString().trim();
            String password = ((EditText) findViewById(R.id.password_edit_text)).getText().toString().trim();
            if(email.equals("")){
                ((EditText) findViewById(R.id.email_edit_text)).setError("Masukkan alamat email anda");
            }else if(password.equals("")){
                ((EditText) findViewById(R.id.password_edit_text)).setError("Masukkan password");
            }else{
//                AuditService apiService = AuditClient.getClient().create(AuditService.class);
//                Call<LoginParser> call = apiService.login(email, password);
//                call.enqueue(new Callback<LoginParser>() {
//                    @Override
//                    public void onResponse(Call<LoginParser> call, Response<LoginParser> response) {
//                        progressDialog.hide();
//
//                        LoginParser loginParser = response.body();
//                        if(loginParser.isSuccess()){
//                            User user = loginParser.getUser();
//                            sessionPreference.createLoginSession(user);
//                            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
//                        }
//                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                        builder.setTitle("Gagal");
//                        builder.setMessage(loginParser.getMessage());
//                        builder.setPositiveButton("OK", null);
//                        builder.show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginParser> call, Throwable t) {
//                        progressDialog.hide();
//
//                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                        builder.setTitle("Gagal");
//                        builder.setMessage(t.getMessage());
//                        builder.setPositiveButton("OK", null);
//                        builder.show();
//                    }
//                });

                progressDialog.show();
                (new Handler()).postDelayed(new Runnable() {
                    public void run() {
                        progressDialog.hide();
                        sessionPreference.createLoginSession(new User(1, "faqiharifianaji@gmail.com"));
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                }, 5000);
            }
        }
    }
}
