package com.example.learnonapp.Utilts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.learnonapp.Activities.LoginActivity;
import com.example.learnonapp.Modal.AdminModal;
import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.Modal.AdminModal;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_ID = "keyid";
    private static final String KEY_NAME = "keyusername";
    private static final String KEY_PHONE = "keyphone";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_PASSWORD = "keypassword";
    private static final String KEY_ADDRESS = "keyaddress";
    private static final String KEY_ROLLNO = "keyrollno";
    private static final String KEY_CLASS = "keyclass";
    private static final String KEY_COLLAGE = "keycollage";
    private static final String KEY_GENDER = "keygender";
    @SuppressLint("StaticFieldLeak")
    private static SharedPrefManager mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //this method will store the user data in shared preferences
    public void userLogin(UsersModal usersModal) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, usersModal.getID());
        editor.putString(KEY_NAME, usersModal.getNAME());
        editor.putString(KEY_PHONE,usersModal.getPHONE());
        editor.putString(KEY_EMAIL, usersModal.getEMAIL());
        editor.putString(KEY_PASSWORD,usersModal.getPASSWORD());
        editor.putString(KEY_ADDRESS,usersModal.getADDRESS());
        editor.putString(KEY_ROLLNO,usersModal.getROLLNO());
        editor.putString(KEY_CLASS,usersModal.getCLASS());
        editor.putString(KEY_COLLAGE,usersModal.getCOLLAGE());
        editor.putString(KEY_GENDER, usersModal.getGENDER());
        editor.apply();
    }

    public void adminLogin(AdminModal adminModal) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_ID, adminModal.getID());
        editor.putString(KEY_NAME, adminModal.getNAME());
        editor.putString(KEY_PHONE,adminModal.getPHONE());
        editor.putString(KEY_EMAIL, adminModal.getEMAIL());
        editor.putString(KEY_PASSWORD,adminModal.getPASSWORD());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, null) != null;
    }

    //this method will give the logged in user
    public UsersModal getUser() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UsersModal (
                sharedPreferences.getString(KEY_ID, String.valueOf(-1)),
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_PHONE, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PASSWORD,null),
                sharedPreferences.getString(KEY_ADDRESS,null),
                sharedPreferences.getString(KEY_ROLLNO,null),
                sharedPreferences.getString(KEY_CLASS,null),
                sharedPreferences.getString(KEY_COLLAGE,null),
                sharedPreferences.getString(KEY_GENDER, null)
        );
    }

    public AdminModal getAdmin() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new AdminModal(
                sharedPreferences.getString(KEY_ID, String.valueOf(-1)),
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_PHONE, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_PASSWORD,null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginActivity.class));
    }
}