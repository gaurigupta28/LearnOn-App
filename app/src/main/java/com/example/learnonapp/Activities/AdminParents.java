package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class AdminParents extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_parents);
        drawerLayout = findViewById(R.id.drawer_layout_admin);

    }
    public  void  ClickMenu(View view ){
        AdminDashboardActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){

        AdminDashboardActivity.closeDrawer(drawerLayout);
    }

    public  void ClickHome(View view){
        AdminDashboardActivity.redirectActivity(this,AdminDashboardActivity.class);
    }

    public void ClickAdminProfile(View view){
        AdminDashboardActivity.redirectActivity(this,AdminProfile.class);

    }
    public  void ClickStudent(View view){
        AdminDashboardActivity.redirectActivity(this,AdminStudent.class);

    }
    public void ClickTeacher(View view){
        AdminDashboardActivity.redirectActivity(this,AdminTeacher.class);

    }
    public  void ClickStudyWork(View view){
        AdminDashboardActivity.redirectActivity(this,AdminStudyWork.class);

    }
    public void ClickParents(View view){
     recreate();

    }
    public  void ClickOthers(View view){
      AdminDashboardActivity.redirectActivity(this,AdminOthers.class);
    }
    public  void ClickLogout(View view){
        AdminDashboardActivity.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        AdminDashboardActivity.closeDrawer(drawerLayout);
    }

}
