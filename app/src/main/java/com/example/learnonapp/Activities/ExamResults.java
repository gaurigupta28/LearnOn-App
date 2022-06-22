package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class ExamResults extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_results);
        drawerLayout = findViewById(R.id.drawer_layout_user);

    }
    public  void  ClickMenu(View view ){
        UserDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        UserDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        UserDashboardActivity.redirectActivity(this,UserDashboardActivity.class);
    }

    public void ClickAttendance(View view){
        UserDashboardActivity.redirectActivity(this,Attendance.class);

    }
    public  void ClickNotice(View view){
        UserDashboardActivity.redirectActivity(this,Notice.class);

    }
    public void ClickFee(View view){
        UserDashboardActivity.redirectActivity(this,Fee.class);

    }
    public  void ClickSchoolBus(View view){
        UserDashboardActivity.redirectActivity(this,SchoolBus.class);

    }
    public void ClickExamResults(View view){
       recreate();

    }
    public  void ClickAssignments(View view){
        UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Assignments.class);
    }
    public void ClickTimeTable(View view){
        UserDashboardActivity.redirectActivity(this,TimeTable.class);

    }
    public  void ClickLibrary(View view){
        UserDashboardActivity.redirectActivity(this,Library.class);

    }
    public  void ClickContactUs(View view){
        UserDashboardActivity.redirectActivity(this,ContactUs.class);
    }
    public  void ClickLogout(View view){
        UserDashboardActivity.logout(this);

    }
    public  void ClickUserProfile(View view){
        UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.UserProfile.class);
    }
    @Override
    protected void onPause() {
        super.onPause();
        UserDashboardActivity.closeDrawer(drawerLayout);
    }

}