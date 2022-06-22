package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class AdminStudyWork extends AppCompatActivity {
    Button btn_add_timetable,btn_detail_timetable;
    Button btn_add_homework,btn_detail_homework;
    Button btn_add_examresults,btn_detail_examresults;
    Button btn_add_book,btn_detail_books;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_study_work);
        drawerLayout = findViewById(R.id.drawer_layout_admin);
        btn_add_timetable = findViewById(R.id.btn_add_timetable);
        btn_detail_timetable =findViewById(R.id.btn_detail_timetable);
        btn_add_examresults = findViewById(R.id.btn_add_examresults);
        btn_detail_examresults = findViewById(R.id.btn_detail_examresults);
        btn_add_book = findViewById(R.id.btn_add_book);
        btn_detail_books = findViewById(R.id.btn_detail_book);

        btn_add_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminStudyWork.this,AddTimeTable.class);
                startActivity(intent);
            }
        });
        btn_detail_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminStudyWork.this,TimeTable.class);
                startActivity(intent);
            }
        });

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
     recreate();

    }
    public void ClickParents(View view){
        AdminDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.AdminParents.class);

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
