package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class AdminOthers extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button btn_add_notice,btn_details_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_others);
        drawerLayout = findViewById(R.id.drawer_layout_admin);

        btn_add_notice=findViewById(R.id.btn_add_notice);
        btn_details_notice = findViewById(R.id.btn_detail_notice);
        btn_add_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminOthers.this, com.example.learnonapp.Activities.AddNotice.class);
                startActivity(i);
            }
        });

        btn_details_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(AdminOthers.this,NoticeDetails.class);
                startActivity(i);
            }
        });

    }
    public  void  ClickMenu(View view ){
        com.example.learnonapp.Activities.AdminDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        com.example.learnonapp.Activities.AdminDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.UserDashboardActivity.class);
    }

    public void ClickAdminProfile(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminProfile.class);

    }
    public  void ClickStudent(View view){
        com.example.learnonapp.Activities.AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminStudent.class);

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
       recreate();
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
