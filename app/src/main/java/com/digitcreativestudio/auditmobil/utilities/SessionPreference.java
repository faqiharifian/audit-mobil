package com.digitcreativestudio.auditmobil.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.digitcreativestudio.auditmobil.HomeActivity;
import com.digitcreativestudio.auditmobil.entities.User;
import com.google.gson.Gson;

/**
 * Created by ADIK on 15/05/2017.
 */

public class SessionPreference {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "AuditMobil";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_USER = "user";



    public SessionPreference(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USER, json);
        editor.commit();
    }

    public User getCustomer(){
        Gson gson = new Gson();
        String json = pref.getString(KEY_USER, "");
        return gson.fromJson(json, User.class);
    }

    public void logoutUser(){
        editor.remove(IS_LOGIN);
        editor.remove(KEY_USER);
        editor.commit();

        Intent i = new Intent(_context, HomeActivity.class);
        Toast.makeText(_context,"Berhasil Logout", Toast.LENGTH_SHORT).show();
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);

    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
