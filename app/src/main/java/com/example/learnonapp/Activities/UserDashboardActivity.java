package com.example.learnonapp.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnonapp.Adapter.NoticeAdapter;
import com.example.learnonapp.Modal.NoticeModal;
import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.SharedPrefManager;
import com.example.learnonapp.Utilts.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserDashboardActivity extends AppCompatActivity {
    DrawerLayout drawerLayoutUser;
    TextView name,classs,rollno;
    TextView nav_user_name;
    RecyclerView recyclerView;
    NoticeAdapter noticeAdapter;
    List<NoticeModal> noticeModalList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        drawerLayoutUser = findViewById(R.id.drawer_layout_user);


        if(SharedPrefManager.getInstance(this).isLoggedIn()) {
            name = findViewById(R.id.txname);
            rollno = findViewById(R.id.txrollno);
            classs = findViewById(R.id.txclass);
            nav_user_name = findViewById(R.id.idTvUserName);

            UsersModal usersModal = SharedPrefManager.getInstance(this).getUser();

            name.setText(usersModal.getNAME());
            rollno.setText(usersModal.getROLLNO());
            classs.setText(usersModal.getCLASS());
            nav_user_name.setText(usersModal.getNAME());
        }else{

            Intent intent = new Intent(UserDashboardActivity.this, com.example.learnonapp.Activities.LoginActivity.class);
            startActivity(intent);
            finish();

        }

        recyclerView = findViewById(R.id.rvnotice);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NoticeProcess();


    }

    private void NoticeProcess() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.NOTICE_SELECT_ALL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String NOTICE = jsonObject.getString("NOTICE");
                            String FULLDESCRIPTION = jsonObject.getString("FULLDESCRIPTION");

                            NoticeModal noticeModal= new NoticeModal(NOTICE,FULLDESCRIPTION);
                            noticeModalList.add(noticeModal);
                        }
                        noticeAdapter = new NoticeAdapter(UserDashboardActivity.this,noticeModalList);
                        recyclerView.setAdapter(noticeAdapter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(UserDashboardActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public  void  ClickMenu(View view ){
        openDrawer(drawerLayoutUser);
    }


    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){

        closeDrawer(drawerLayoutUser);
    }

    public static  void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
    }

    public  void ClickHome(View view){
        recreate();
    }
    public void ClickAttendance(View view){
        redirectActivity(this,Attendance.class);

    }
    public  void ClickNotice(View view){
        redirectActivity(this,Notice.class);

    }
    public void ClickFee(View view){
        redirectActivity(this,Fee.class);

    }
    public void ClickContactUs(View view){
        redirectActivity(this,ContactUs.class);

    }
    public  void ClickSchoolBus(View view){
        redirectActivity(this,SchoolBus.class);

    }
    public void ClickExamResults(View view){
        redirectActivity(this, com.example.learnonapp.Activities.ExamResults.class);

    }
    public  void ClickAssignments(View view){
        redirectActivity(this, com.example.learnonapp.Activities.Assignments.class);

    }
    public void ClickTimeTable(View view){
        redirectActivity(this,TimeTable.class);

    }
    public  void ClickLibrary(View view){
        redirectActivity(this,Library.class);

    }
    public  void ClickUserProfile(View view){
        redirectActivity(this, com.example.learnonapp.Activities.UserProfile.class);

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
        closeDrawer(drawerLayoutUser);
    }
}