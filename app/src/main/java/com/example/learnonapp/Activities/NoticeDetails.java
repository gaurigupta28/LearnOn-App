package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnonapp.Adapter.NoticeAdapter;
import com.example.learnonapp.Modal.NoticeModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NoticeDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    NoticeAdapter noticeAdapter;
    List<NoticeModal> noticeModalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_details);

        recyclerView = findViewById(R.id.rvnotice);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NoticeProcess();
    }

    private void NoticeProcess() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.NOTICE_SELECT_ALL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String NOTICE = jsonObject.getString("NOTICE");
                            String FULLDESCRIPTION = jsonObject.getString("FULLDESCRIPTION");

                            NoticeModal noticeModal= new NoticeModal(NOTICE,FULLDESCRIPTION);
                            noticeModalList.add(noticeModal);
                        }
                        noticeAdapter = new NoticeAdapter(NoticeDetails.this,noticeModalList);
                        recyclerView.setAdapter(noticeAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(NoticeDetails.this,error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);

    }

}