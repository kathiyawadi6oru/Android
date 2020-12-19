package com.example.pr6;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    int count=0;
    List<String[]> myListData;
    public RecyclerAdapter(List<String[]> myListData){
        this.myListData=myListData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("ONCREATE-VIEW-HOLDER",""+count++);

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_item_rv,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(myListData.get(position)[0]);
        holder.tvSubject.setText(myListData.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return 500;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle,tvSubject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById(R.id.imageView);
            tvTitle =itemView.findViewById(R.id.tvTitle);
            tvSubject =itemView.findViewById(R.id.tvSubject);
        }
    }
}
