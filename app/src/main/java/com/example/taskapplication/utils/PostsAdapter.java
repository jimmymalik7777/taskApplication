package com.example.taskapplication.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapplication.R;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyviewHolder> {

    Context context;
    List<Posts> postList;

    public PostsAdapter(Context context, List<Posts> postsList) {
        this.context = context;
        this.postList = postsList;
    }

    public void setPostList(List<Posts> postsList) {
        this.postList = postsList;
        notifyDataSetChanged();
    }

    @Override
    public PostsAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_posts,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostsAdapter.MyviewHolder holder, int position) {
        holder.title.setText(postList.get(position).getTitle().toString());
        holder.body.setText(postList.get(position).getBody().toString());
//        Glide.with(context).load(movieList.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(postList != null){
            return postList.size();
        }
        return 0;

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;

        public MyviewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.titleText);
            body = (TextView)itemView.findViewById(R.id.bodyText);
        }
    }

}
