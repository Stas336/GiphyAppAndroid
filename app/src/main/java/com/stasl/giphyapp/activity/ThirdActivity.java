package com.stasl.giphyapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.stasl.giphyapp.R;

public class ThirdActivity extends AppCompatActivity
{
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        image = (ImageView)findViewById(R.id.imageView3);
        Glide.with(this)
                .load(getIntent().getStringExtra("imageURL"))
                .asGif()
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}