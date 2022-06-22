package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class SchoolBus extends AppCompatActivity {
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_bus);
        drawerLayout = findViewById(R.id.drawer_layout_user);

    }
    public  void  ClickMenu(View view ){
        com.example.learnonapp.Activities.UserDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        com.example.learnonapp.Activities.UserDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.UserDashboardActivity.class);
    }

    public void ClickAttendance(View view){
         com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Attendance.class);
    }
    public  void ClickNotice(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Notice.class);

    }
    public void ClickFee(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Fee.class);

    }
    public  void ClickSchoolBus(View view){
      recreate();

    }
    public void ClickExamResults(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.ExamResults.class);

    }
    public  void ClickAssignments(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Assignments.class);
    }
    public void ClickTimeTable(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,TimeTable.class);

    }
    public  void ClickLibrary(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Library.class);

    }
    public  void ClickContactUs(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,ContactUs.class);
    }
    public  void ClickLogout(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.logout(this);

    }
    public  void ClickUserProfile(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.UserProfile.class);
    }
    @Override
    protected void onPause() {
        super.onPause();
        com.example.learnonapp.Activities.UserDashboardActivity.closeDrawer(drawerLayout);
    }

}