package com.blogspot.randomtravelerofindia.travel;

import com.blogspot.randomtravelerofindia.travel.Post_Model.Form;
import com.blogspot.randomtravelerofindia.travel.Post_Model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public class BloggerAPI {

    //generate KEY & URL from blogger api (google)
    public static final String KEY = "AIzaSyCW88XFphdeb-eYIYgy3bdexlb_s46Bjls";
    public static final String URL = "https://www.googleapis.com/blogger/v3/blogs/8761239217852090091/posts/";

    //steps 4 retrofit: create interface & implement using retrofit
    public static PostService postService = null;

    public static PostService getPostService(){
        if (postService== null){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService{
        //to get all the post: GET BaseURL?key=YOUR-API-KEY
        //@GET("?key="+KEY) //if less then 10 post i.e, without paging implementation

        @GET
        Call<com.blogspot.randomtravelerofindia.travel.PostList> getPostList(@Url String url);//dynamic url

        @POST("post?login=true")
        Call<User> createAccount(@Body Form form);

//        //to get individual post: GET BaseURL/postId/?key=YOUR-API-KEY
//        @GET("{postId}/?key="+KEY)
//        Call<com.blogspot.randomtravelerofindia.travel.Item> getPostbyId(@Path("postId") String id);

    }

}
