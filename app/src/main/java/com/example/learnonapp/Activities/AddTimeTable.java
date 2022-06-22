package com.example.learnonapp.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.learnonapp.R;

import java.io.IOException;
import java.io.InputStream;

public class AddTimeTable extends AppCompatActivity {
    EditText edfilename;
    TextView tvDoc;
    Button btn_select_doc,btn_upload_doc;
    private  int REQ_PDF = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_table);
        edfilename = findViewById(R.id.documentename);
        tvDoc = findViewById(R.id.tvDocuments);
        btn_select_doc = findViewById(R.id.btnselectDocument);
        btn_upload_doc = findViewById(R.id.btnUploadDocument);


        btn_select_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
                chooseFile.setType("application/pdf");
                chooseFile = Intent.createChooser(chooseFile,"Choose a file");
                startActivityForResult(chooseFile,REQ_PDF);


            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_PDF && resultCode == RESULT_OK && data != null){

             Uri path = data.getData();
            try {
                InputStream inputStream = AddTimeTable.this.getContentResolver().openInputStream(path);
                byte[] pdfInBytes = new byte[inputStream.available()];
                inputStream.read(pdfInBytes);


                tvDoc.setText("Document Selected");
                btn_select_doc.setText("Change Document");

                Toast.makeText(this, "Document Selected", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}