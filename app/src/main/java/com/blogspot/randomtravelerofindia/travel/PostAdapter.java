package com.blogspot.randomtravelerofindia.travel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private Context context;
    private List<com.blogspot.randomtravelerofindia.travel.Item> items;

    public PostAdapter(Context context, List<com.blogspot.randomtravelerofindia.travel.Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_user_layout,viewGroup,false);
        Toast.makeText(context, ""+i, Toast.LENGTH_SHORT).show();
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        final com.blogspot.randomtravelerofindia.travel.Item item=items.get(i);
        postViewHolder.textView.setText(item.getTitle());

        Document document=Jsoup.parse(item.getContent());
        postViewHolder.textView1.setText(document.text());

        Elements elements=document.select("img");
        Glide.with(context).load(elements.get(0).attr("src")).into(postViewHolder.imageView);

        postViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+item.getUrl(), Toast.LENGTH_SHORT).show();
                Toast.makeText(context, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView1;
        ImageView imageView;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
