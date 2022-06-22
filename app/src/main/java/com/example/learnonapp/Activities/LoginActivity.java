package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.learnonapp.Modal.AdminModal;
import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.SharedPrefManager;
import com.example.learnonapp.Utilts.URLs;
import com.example.learnonapp.Utilts.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText edemail, edpassword;
    Button btn_register, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        edemail = findViewById(R.id.idETemail);
        edpassword = findViewById(R.id.idETpassword);



        btn_login = findViewById(R.id.idBtnLogin);
        btn_register = findViewById(R.id.idBtnRegister);


        btn_register.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        btn_login.setOnClickListener(view -> {

            final String email = edemail.getText().toString();
            final String password = edpassword.getText().toString();


            if (email.isEmpty()) {
                edemail.setError("Email is required");
                edemail.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                edpassword.setError("Password is required");
                edpassword.requestFocus();
                return;
            }

            if(email.equals("admin") && password.equals("12345")){
                AdminLoginProcess(email,password);

            }else{
                UserLoginProcess(email,password);
            }

        });


    }

    private void AdminLoginProcess(String email, String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_ADMIN_LOGIN,
                this::onResponse1,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("EMAIL", email);
                params.put("PASSWORD", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void onResponse1(String response) {

        try {
//converting response to json object
            JSONObject obj = new JSONObject(response);

//if no error in response
            if (!obj.getBoolean("error")) {
                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                //getting the user from the response
                JSONObject adminJson = obj.getJSONObject("tbladmin");

                //creating a new user object
                AdminModal adminModal;
                adminModal = new AdminModal(
                        adminJson.getString("ID"),
                        adminJson.getString("NAME"),
                        adminJson.getString("PHONE"),
                        adminJson.getString("EMAIL"),
                        adminJson.getString("PASSWORD")

                );

                //storing the user in shared preferences
                SharedPrefManager.getInstance(getApplicationContext()).adminLogin(adminModal);

                //starting the profile activity
                finish();
                startActivity(new Intent(getApplicationContext(), AdminDashboardActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void UserLoginProcess(String email,String password) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_LOGIN,
                this::onResponse,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("EMAIL", email);
                params.put("PASSWORD", password);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void onResponse(String response) {

        try {
//converting response to json object
            JSONObject obj = new JSONObject(response);

//if no error in response
            if (!obj.getBoolean("error")) {
                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                //getting the user from the response
                JSONObject userJson = obj.getJSONObject("tblusers");

                //creating a new user object
                UsersModal usersModal;
                usersModal = new UsersModal(
                        userJson.getString("ID"),
                        userJson.getString("NAME"),
                        userJson.getString("PHONE"),
                        userJson.getString("EMAIL"),
                        userJson.getString("PASSWORD"),
                        userJson.getString("ADDRESS"),
                        userJson.getString("ROLLNO"),
                        userJson.getString("CLASS"),
                        userJson.getString("COLLAGE"),
                        userJson.getString("GENDER")
                );

                //storing the user in shared preferences
                SharedPrefManager.getInstance(getApplicationContext()).userLogin(usersModal);

                //starting the profile activity
                finish();
                startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
            } else {
                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
