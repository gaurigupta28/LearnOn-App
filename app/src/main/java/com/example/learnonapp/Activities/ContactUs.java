package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class ContactUs extends AppCompatActivity {
 DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
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
     com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Attendance.class);

    }
    public  void ClickNotice(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Notice.class);

    }
    public void ClickFee(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Fee.class);

    }
    public  void ClickSchoolBus(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.SchoolBus.class);

    }
    public void ClickExamResults(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.ExamResults.class);

    }
    public  void ClickAssignments(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Assignments.class);
    }
    public void ClickTimeTable(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.TimeTable.class);

    }
    public  void ClickLibrary(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Library.class);

    }
    public  void ClickContactUs(View view){
       recreate();
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