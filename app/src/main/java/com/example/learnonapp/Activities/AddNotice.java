package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddNotice extends AppCompatActivity {
    EditText ednotice,edfulldecription,edisactive;
    Button btn_add_notice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);
        btn_add_notice = findViewById(R.id.btn_add_new_notice);
        ednotice= findViewById(R.id.edtNotice);
        edfulldecription = findViewById(R.id.edFulldescription);
        edisactive = findViewById(R.id.edtIsactive);
        btn_add_notice.setOnClickListener(new View.OnClickListener() {

            private void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    Toast.makeText(AddNotice.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
// and setting data to edit text as empty
                ednotice.setText("");
                edfulldecription.setText("");
                edisactive.setText("");
            }
            @Override
            public void onClick(View view) {
                NoticeProcess();

            }

            private void NoticeProcess() {

                final String notice = ednotice.getText().toString().trim();
                final String fulldescription = edfulldecription.getText().toString().trim();
                final String isactive = edisactive.getText().toString().trim();

                NoticeInsert(notice,fulldescription,isactive);
                Intent i = new Intent(AddNotice.this,NoticeDetails.class);
                startActivity(i);


            }

            private void NoticeInsert(String notice, String fulldescription, String isactive) {

                RequestQueue queue = Volley.newRequestQueue(AddNotice.this);

                StringRequest request = new StringRequest(Request.Method.POST, URLs.INSERT_NOTICE,
                        this::onResponse, error ->
                        Toast.makeText(AddNotice.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show()) {
                    @Override
                    public String getBodyContentType() {
                        // as we are passing data in the form of url encoded
                        // so we are passing the content type below
                        return "application/x-www-form-urlencoded; charset=UTF-8";
                    }

                    @Override
                    protected Map<String, String> getParams() {

                        Map<String, String> params = new HashMap<>();

                        params.put("NOTICE", notice);
                        params.put("FULLDESCRIPTION", fulldescription);
                        params.put("ISACTIVE", isactive);

                        return params;
                    }
                };
                queue.add(request);
            }

        });
    }

}