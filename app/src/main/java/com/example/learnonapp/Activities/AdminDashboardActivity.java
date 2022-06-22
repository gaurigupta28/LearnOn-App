package com.example.learnonapp.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.R;

public class AdminDashboardActivity extends AppCompatActivity {
    DrawerLayout drawerLayoutAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        drawerLayoutAdmin = findViewById(R.id.drawer_layout_admin);
    }
    public  void  ClickMenu(View view ){
        openDrawer(drawerLayoutAdmin);
    }


    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){

        closeDrawer(drawerLayoutAdmin);
    }

    public static  void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public  void ClickHome(View view){
        recreate();
    }
    public void ClickStudent(View view){
        redirectActivity(this,AdminStudent.class);

    }

    public  void ClickAdminProfile(View view){
        redirectActivity(this, com.example.learnonapp.Activities.AdminProfile.class);

    }
    public  void ClickTeacher(View view){
        redirectActivity(this, com.example.learnonapp.Activities.AdminTeacher.class);

    }
    public void ClickStudyWork(View view){
        redirectActivity(this, com.example.learnonapp.Activities.AdminStudyWork.class);

    }
    public void ClickParents(View view){
        redirectActivity(this, com.example.learnonapp.Activities.AdminParents.class);

    }
    public  void ClickOthers(View view){
        redirectActivity(this,AdminOthers.class);

    }


    public void ClickLogout(View view){
        logout(this);

    }

    public static void logout(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//Adding positive button
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                activity.finishAffinity();
                System.exit(0);

            }
        });
//Adding negative button
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });

        builder.show();

    }

    public static  void redirectActivity(Activity activity, Class aClass)  {

        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayoutAdmin);
    }
}