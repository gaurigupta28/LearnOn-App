package com.example.learnonapp.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class Assignments extends AppCompatActivity {
    WebView web_view;
    String path;
    DrawerLayout drawerLayout;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        drawerLayout = findViewById(R.id.drawer_layout_user);
        web_view=(WebView)findViewById(R.id.web_view);
        path="http://spsexam.appstide.com";
        web_view.setWebViewClient(new WebViewClient());
        WebSettings webSettings = web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        web_view.loadUrl(path);

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
    public  void ClickUserProfile(View view){
       UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.UserProfile.class);
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
        UserDashboardActivity.redirectActivity(this,ExamResults.class);

    }
    public  void ClickAssignments(View view){
        recreate();
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

    @Override
    protected void onPause() {
        super.onPause();
        UserDashboardActivity.closeDrawer(drawerLayout);
    }

}