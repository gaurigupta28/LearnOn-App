package com.example.learnonapp.Adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnonapp.Modal.TimeTableModal;
import com.example.learnonapp.R;
import com.example.learnonapp.Utilts.DownloadTask;
import com.example.learnonapp.Utilts.URLs;

import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder> {
    Context context;
    List<TimeTableModal> timeTableModalList;


    public TimeTableAdapter(Context context, List<TimeTableModal> timeTableModalList) {
        this.context= context;
        this.timeTableModalList = timeTableModalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.timetable_rv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TimeTableModal timeTableModal = timeTableModalList.get(position);
        holder.FILENAME.setText(timeTableModal.getFILENAME());
        holder.FILE.setText(timeTableModal.getFILE());
        holder.DOWNLOAD.setOnClickListener(new View.OnClickListener() {
            DownloadManager manager;
            final View.OnClickListener c = this;
            @Override
            public void onClick(View view) {
                String url = URLs.TIMETABLE_SELECT_ALL +timeTableModal.getFILE();
                String name = timeTableModal.getFILE();
                new DownloadTask(context, name, url);

            }
        });
    }

    @Override
    public int getItemCount() {
        return timeTableModalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView FILENAME,FILE;
        CardView DOWNLOAD;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            FILENAME = itemView.findViewById(R.id.tvfilename);
            FILE = itemView.findViewById(R.id.tvfile);
            DOWNLOAD = itemView.findViewById(R.id.tvdownload);

        }
    }
}
