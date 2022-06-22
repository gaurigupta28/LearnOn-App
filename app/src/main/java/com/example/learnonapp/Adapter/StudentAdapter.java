package com.example.learnonapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnonapp.Modal.UsersModal;
import com.example.learnonapp.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    Context context;
    List<UsersModal> usersModalList;


    public StudentAdapter(Context context, List<UsersModal> usersModalList) {
        this.context= context;
        this.usersModalList = usersModalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_rv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UsersModal usersModal = usersModalList.get(position);
        holder.ID.setText((usersModal.getID()));
        holder.NAME.setText(usersModal.getNAME());
        holder.PHONE.setText(usersModal.getPHONE());
        holder.EMAIL.setText(usersModal.getEMAIL());
        holder.PASSWORD.setText(usersModal.getPASSWORD());
        holder.ADDRESS.setText(usersModal.getADDRESS());
        holder.ROLLNO.setText(usersModal.getROLLNO());
        holder.CLASS.setText(usersModal.getCLASS());
        holder.COLLAGE.setText(usersModal.getCOLLAGE());
        holder.GENDER.setText(usersModal.getGENDER());
    }

    @Override
    public int getItemCount() {
        return usersModalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ID,NAME,PHONE,GENDER,EMAIL,PASSWORD,ADDRESS,ROLLNO,CLASS,COLLAGE;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.id);
            NAME = itemView.findViewById(R.id.idTVName);
            PHONE = itemView.findViewById(R.id.idTVPhone);
            EMAIL = itemView.findViewById(R.id.idTVEmail);
            PASSWORD = itemView.findViewById(R.id.idTVPassword);
            ADDRESS = itemView.findViewById(R.id.idTVAddress);
            ROLLNO = itemView.findViewById(R.id.idTVRollno);
            CLASS = itemView.findViewById(R.id.idTVClass);
            COLLAGE = itemView.findViewById(R.id.idTVCollage);
            GENDER = itemView.findViewById(R.id.idTVGender);

        }
    }
}
