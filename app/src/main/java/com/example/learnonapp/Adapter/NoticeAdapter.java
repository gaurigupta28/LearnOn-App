package com.example.learnonapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnonapp.Activities.FullDetailsNotice;
import com.example.learnonapp.Modal.NoticeModal;
import com.example.learnonapp.R;

import java.util.List;


public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {
    Context context;
    List<NoticeModal> noticeModalList;


    public NoticeAdapter(Context context,  List<NoticeModal> noticeModalList) {
        this.context= context;
        this.noticeModalList = noticeModalList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_notice, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NoticeModal noticeModal = noticeModalList.get(position);
        holder.NOTICE.setText(noticeModal.getNOTICE());
        holder.FULLDESCRIPTION.setText(noticeModal.getFULLDESCRIPTION());

        holder.NOTICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,FullDetailsNotice.class);
                intent.putExtra("NOTICE",noticeModal.getNOTICE());
                intent.putExtra("FULLDESCRIPTION",noticeModal.getFULLDESCRIPTION());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return noticeModalList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView NOTICE,FULLDESCRIPTION;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NOTICE = itemView.findViewById(R.id.tvnotice);
            FULLDESCRIPTION = itemView.findViewById(R.id.tvfullnotice);

        }
    }
}
