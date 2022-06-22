package com.example.learnonapp.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.SharedPrefManager;
import com.example.learnonapp.Utilts.URLs;
import com.example.learnonapp.Utilts.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText edname, edphone, edemail, edpassword, edaddress, edrollno, edclass, edcollage, edgender;
    Button btn_register, btn_login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressBar = findViewById(R.id.progressBar);
        btn_login = findViewById(R.id.login);
        btn_register = findViewById(R.id.register);

        btn_login.setOnClickListener(view -> {
            Intent intent = new Intent(RegisterActivity.this, com.example.learnonapp.Activities.LoginActivity.class);
            startActivity(intent);
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterProcess();

            }
        });
    }

            private void RegisterProcess() {

                edname = findViewById(R.id.ideditName);
                edphone = findViewById(R.id.ideditphone);
                edclass = findViewById(R.id.editclass);
                edemail = findViewById(R.id.ideditemail);
                edphone = findViewById(R.id.ideditphone);
                edpassword = findViewById(R.id.editpassword);
                edaddress = findViewById(R.id.editAddress);
                edrollno = findViewById(R.id.editrollno);
                edcollage = findViewById(R.id.editCollage);
                edgender = findViewById(R.id.editgender);

                final String name = edname.getText().toString().trim();
                final String phone = edphone.getText().toString().trim();
                final String classs = edclass.getText().toString().trim();
                final String email = edemail.getText().toString().trim();
                final String password = edpassword.getText().toString().trim();
                final String address = edaddress.getText().toString().trim();
                final String rollno = edrollno.getText().toString().trim();
                final String collage = edcollage.getText().toString().trim();
                final String gender = edgender.getText().toString().trim();

                if (name.isEmpty()) {
                    edname.setError("Email is required");
                    edname.requestFocus();
                    return;
                }

                if (phone.isEmpty()) {
                    edphone.setError("Password is required");
                    edphone.requestFocus();
                    return;
                }
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
                if (address.isEmpty()) {
                    edaddress.setError("Address is required");
                    edaddress.requestFocus();
                    return;
                }

                if (rollno.isEmpty()) {
                    edrollno.setError("Roll NO is required");
                    edrollno.requestFocus();
                    return;
                }
                if (classs.isEmpty()) {
                    edclass.setError("Class is required");
                    edclass.requestFocus();
                    return;
                }

                if (collage.isEmpty()) {
                    edcollage.setError("Collage is required");
                    edcollage.requestFocus();
                    return;
                }
                if (gender.isEmpty()) {
                    edgender.setError("Gender is required");
                    edgender.requestFocus();
                    return;
                }

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_REGISTER,
                        response -> {
                            progressBar.setVisibility(View.GONE);

                            try {
                                //converting response to json object
                                JSONObject obj = new JSONObject(response);
                                //if no error in response
                                if (!obj.getBoolean("error")) {
                                    Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                    //getting the user from the response
                                    JSONObject userJson = obj.getJSONObject("tblusers");

                                    //creating a new user object
                                    UsersModal usersModal = new UsersModal(
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
                                    startActivity(new Intent(getApplicationContext(), com.example.learnonapp.Activities.LoginActivity.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("NAME", name);
                        params.put("PHONE", phone);
                        params.put("EMAIL", email);
                        params.put("PASSWORD", password);
                        params.put("ADDRESS", address);
                        params.put("ROLLNO", rollno);
                        params.put("CLASS", classs);
                        params.put("COLLAGE", collage);
                        params.put("GENDER", gender);
                        return params;
                    }
                };

                VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
            }

    }
