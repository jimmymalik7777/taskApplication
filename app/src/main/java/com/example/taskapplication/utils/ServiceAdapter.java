package com.example.taskapplication.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taskapplication.R;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.serviceViewholder> {
    private ServicesModel[] listdata;
    private Context context;

    public ServiceAdapter(ServicesModel[] listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public serviceViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.row_services, parent, false);
        serviceViewholder serviceViewholder = new serviceViewholder(listItem);
        return serviceViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull serviceViewholder holder, int position) {

        final ServicesModel servicesModel = listdata[position];
        holder.title.setText(listdata[position].getTitle());
        Glide.with(context)
                .load(listdata[position].getImage())
                .into(holder.image);




    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class serviceViewholder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView image;
        public serviceViewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.serviceText);
            image = itemView.findViewById(R.id.serviceImg);

        }
    }
}
