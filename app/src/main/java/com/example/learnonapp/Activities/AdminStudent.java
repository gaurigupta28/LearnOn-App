package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnonapp.Adapter.StudentAdapter;
import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdminStudent extends AppCompatActivity {
    Button btn_add;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    List<UsersModal> usersModalList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);
        drawerLayout = findViewById(R.id.drawer_layout_admin);
        btn_add = findViewById(R.id.btn_add_student);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(AdminStudent.this, com.example.learnonapp.Activities.RegisterActivity.class);
                startActivity(i1);
            }
        });

        recyclerView = findViewById(R.id.idrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentDataLoadingProcess();

    }

    private void StudentDataLoadingProcess() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.STUDENT_SELECT_ALL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String ID = jsonObject.getString("ID");
                            String NAME = jsonObject.getString("NAME");
                            String PHONE = jsonObject.getString("PHONE");
                            String EMAIL = jsonObject.getString("EMAIL");
                            String PASSWORD = jsonObject.getString("PASSWORD");
                            String ADDRESS = jsonObject.getString("ADDRESS");
                            String ROLLNO = jsonObject.getString("ROLLNO");
                            String CLASS = jsonObject.getString("CLASS");
                            String COLLAGEE = jsonObject.getString("COLLAGE");
                            String GENDER = jsonObject.getString("GENDER");
                            UsersModal usersModal = new UsersModal(ID,NAME,PHONE,EMAIL,PASSWORD,ADDRESS,ROLLNO,CLASS,COLLAGEE,GENDER);
                            usersModalList.add(usersModal);

                        }
                        studentAdapter = new StudentAdapter(AdminStudent.this ,usersModalList);
                        recyclerView.setAdapter(studentAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(AdminStudent.this,error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);

    }

    public  void  ClickMenu(View view ){
        com.example.learnonapp.Activities.AdminDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        com.example.learnonapp.Activities.AdminDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminDashboardActivity.class);
    }

    public void ClickAdminProfile(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminProfile.class);

    }
    public  void ClickStudent(View view){
      recreate();
    }
    public void ClickTeacher(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminTeacher.class);

    }
    public  void ClickStudyWork(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminStudyWork.class);

    }
    public void ClickParents(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminParents.class);

    }
    public  void ClickOthers(View view){
     com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this,AdminOthers.class);
    }
    public  void ClickLogout(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        com.example.learnonapp.Activities.AdminDashboardActivity.closeDrawer(drawerLayout);
    }

}
