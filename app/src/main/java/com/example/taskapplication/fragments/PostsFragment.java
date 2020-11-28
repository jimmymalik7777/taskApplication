package com.example.taskapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taskapplication.R;
import com.example.taskapplication.utils.ApiClient;
import com.example.taskapplication.utils.ApiInterface;
import com.example.taskapplication.utils.Posts;
import com.example.taskapplication.utils.PostsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsFragment extends Fragment {


    RecyclerView postRv;
    PostsAdapter recyclerAdapter;
    List<Posts> postsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_posts, container, false);
        postRv = v.findViewById(R.id.postRv);

        postsList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        postRv.setLayoutManager(layoutManager);
        recyclerAdapter = new PostsAdapter(getContext(),postsList);
        postRv.setAdapter(recyclerAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Posts>> call = apiService.getBody();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                postsList = response.body();
                Log.d("TAG","Response = "+postsList);
                recyclerAdapter.setPostList(postsList);

            }
            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });

        return v;
    }
}