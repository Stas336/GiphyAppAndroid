package com.stasl.giphyapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.stasl.giphyapp.R;

public class ImageViewActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView image = (ImageView)findViewById(R.id.imageView3);
        String[] split = getIntent().getStringExtra("imageURL").split(";");
        Glide.with(this)
                .load(split[0])
                .asGif()
                .placeholder(R.drawable.ic_cached_black_48dp)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
        if (!split[1].equals("0000-00-00 00:00:00") && !split[1].equals("1970-01-01 00:00:00"))
        {
            Toast.makeText(this, "Trending datetime: " + split[1], Toast.LENGTH_SHORT).show();
        }
    }
}
