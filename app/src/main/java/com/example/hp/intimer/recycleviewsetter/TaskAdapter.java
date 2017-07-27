package com.example.hp.intimer.recycleviewsetter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.intimer.R;

import java.util.List;

/**
 * Created by hp on 020 20.07.2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Task> taskList;

    private int position;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(itemView);

        Task task = taskList.get(position);
        holder.title.setText(task.getTitle());
        holder.textViewTimeCV.setText(task.getTime());
        holder.startStop(task.getTime());

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        this.position = position;
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }





}
