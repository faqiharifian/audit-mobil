package com.digitcreativestudio.auditmobil.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

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



    public SessionPreference(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void createLoginSession(){
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public void logoutUser(){
        editor.putBoolean(IS_LOGIN, false);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
