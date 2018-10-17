package com.blogspot.randomtravelerofindia.travel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AbsListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;
    PostAdapter adapter;
    List<com.blogspot.randomtravelerofindia.travel.Item> items=new ArrayList<>();

    Boolean isScrolling = false;
    int currentItems, totalItems, scrolledOutItems;

    String token ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.user_list);
        manager=new LinearLayoutManager(this);
        adapter=new PostAdapter(this,items);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState==AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems=manager.getChildCount();
                scrolledOutItems=manager.findFirstVisibleItemPosition();
                totalItems=manager.getItemCount();

                if((isScrolling) && (currentItems+scrolledOutItems==totalItems)){
                    isScrolling=false;
                    getData();
                }
            }
        });

        getData();
    }

    private void getData(){

        String url=BloggerAPI.URL+"?key="+BloggerAPI.KEY;
        if(token!=""){
            url=url+"&pageToken="+token;
            Toast.makeText(MainActivity.this, "Next Page.", Toast.LENGTH_SHORT).show();
        }

        if (token==null){
            Toast.makeText(MainActivity.this, "END.", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<com.blogspot.randomtravelerofindia.travel.PostList> postList = BloggerAPI.getPostService().getPostList(url);

        postList.enqueue(new Callback<com.blogspot.randomtravelerofindia.travel.PostList>() {
            @Override
            public void onResponse(Call<com.blogspot.randomtravelerofindia.travel.PostList> call, Response<com.blogspot.randomtravelerofindia.travel.PostList> response) {

                com.blogspot.randomtravelerofindia.travel.PostList list=response.body();
                token=list.getNextPageToken();
                items.addAll(list.getItems());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<com.blogspot.randomtravelerofindia.travel.PostList> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error Occurred.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
