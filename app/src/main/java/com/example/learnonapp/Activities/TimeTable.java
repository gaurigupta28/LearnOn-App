package com.example.learnonapp.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnonapp.Adapter.TimeTableAdapter;
import com.example.learnonapp.Modal.TimeTableModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TimeTable extends AppCompatActivity {

    RecyclerView recyclerView;
    TimeTableAdapter timeTableAdapter;
    List<TimeTableModal> timeTableModalList = new ArrayList<>();
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        drawerLayout = findViewById(R.id.drawer_layout_user);

        recyclerView = findViewById(R.id.rvtimetable);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TimeTableDataLoadingProcess();

    }

    private void TimeTableDataLoadingProcess() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.TIMETABLE_SELECT_ALL,
                response -> {
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String FILENAME = jsonObject.getString("FILENAME");
                            String FILE = jsonObject.getString("FILE");
                            TimeTableModal timeTableModal = new TimeTableModal(FILENAME,FILE);
                            timeTableModalList.add(timeTableModal);
                        }
                        timeTableAdapter = new TimeTableAdapter(TimeTable.this, timeTableModalList);
                        recyclerView.setAdapter(timeTableAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }, error -> Toast.makeText(TimeTable.this,error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(this).add(stringRequest);
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
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this, com.example.learnonapp.Activities.Notice.class);

    }
    public void ClickFee(View view){
        com.example.learnonapp.Activities.UserDashboardActivity.redirectActivity(this,Fee.class);

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
       recreate();

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