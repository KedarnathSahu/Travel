package com.blogspot.randomtravelerofindia.travel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.randomtravelerofindia.travel.Post_Model.Form;
import com.blogspot.randomtravelerofindia.travel.Post_Model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.blogspot.randomtravelerofindia.travel.BloggerAPI.URL;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager manager;
    PostAdapter adapter;
    List<com.blogspot.randomtravelerofindia.travel.Item> items=new ArrayList<>();

    Boolean isScrolling = false;
    int currentItems, totalItems, scrolledOutItems;

    String token ="";

    EditText emailId;
    EditText password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //POST REQUEST
        emailId=(EditText) findViewById(R.id.editText2);
        password=(EditText) findViewById(R.id.editText);
        button=(Button) findViewById(R.id.button);

        //GET REQUEST
        recyclerView =findViewById(R.id.user_list);
        manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
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

        String url=URL+"?key="+BloggerAPI.KEY;
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

    public void postData(View view) {
        Form form =new Form();
        form.setId(emailId.getText().toString());
        form.setPassword(password.getText().toString());
        sendNetworkRequest(form);
    }

    private void sendNetworkRequest(Form form){
        //http://httpbin.org/post?login=true
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://www.httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BloggerAPI.PostService postService=retrofit.create(BloggerAPI.PostService.class);
        Call<User> postCall=postService.createAccount(form);
        postCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.code()==200) {
                    assert response.body() != null;
                    String jsonString = response.body().getData();
                    Gson g = new Gson();
                    Form userData = g.fromJson(jsonString, Form.class);
                    Toast.makeText(MainActivity.this, "Log In: " + userData.getId(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "POST: Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
