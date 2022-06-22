package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnonapp.R;

public class FullDetailsNotice extends AppCompatActivity {
    TextView txfullnotice,txnotice;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_details_notice);
        txnotice = (TextView)findViewById(R.id.txnotice);
        txfullnotice=(TextView)findViewById(R.id.txfullnotice);
        back=(Button)findViewById(R.id.btncancle);
        Intent intent=getIntent();

        String notice = intent.getStringExtra("NOTICE");
        String fullnotice = intent.getStringExtra("FULLDESCRIPTION");

        txnotice.setText(notice);
        txfullnotice.setText(fullnotice);

        back=(Button)findViewById(R.id.btncancle);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}