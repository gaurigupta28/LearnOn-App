package com.example.learnonapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.SharedPrefManager;

public class UserProfile extends AppCompatActivity {
    TextView id,name,phone,email,password,address,rollno,classs,collage,gender;
    Button btn_logout,btn_edit;
     DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        drawerLayout = findViewById(R.id.drawer_layout_user);
        btn_logout = findViewById(R.id.idbtnLogout);
        btn_edit = findViewById(R.id.idbtnEdit);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(view.equals(btn_logout)){
                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                }
            }
        });

        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            id = findViewById(R.id.id);
            name = findViewById(R.id.idTVName);
            phone = findViewById(R.id.idTVPhone);
            email = findViewById(R.id.idTVEmail);
            password = findViewById(R.id.idTVPassword);
            address = findViewById(R.id.idTVAddress);
            rollno = findViewById(R.id.idTVRollno);
            classs = findViewById(R.id.idTVClass);
            collage = findViewById(R.id.idTVCollage);
            gender = findViewById(R.id.idTVGender);
            UsersModal usersModal = SharedPrefManager.getInstance(this).getUser();

            id.setText(String.valueOf(usersModal.getID()));
            name.setText(usersModal.getNAME());
            phone.setText(usersModal.getPHONE());
            email.setText(usersModal.getEMAIL());
            password.setText(usersModal.getPASSWORD());
            address.setText(usersModal.getADDRESS());
            rollno.setText(usersModal.getROLLNO());
            classs.setText(usersModal.getCLASS());
            collage.setText(usersModal.getCOLLAGE());
            gender.setText(usersModal.getGENDER());
        }else{

            Intent intent = new Intent(UserProfile.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

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
    public  void ClickHomeWork(View view){
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
        UserDashboardActivity.redirectActivity(this,Assignments.class);
    }

    public  void ClickUserProfile(View view){
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