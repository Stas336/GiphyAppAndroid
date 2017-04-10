package com.stasl.giphyapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.stasl.giphyapp.R;
import com.stasl.giphyapp.activity.ImageViewActivity;
import com.stasl.giphyapp.gif.Data;
import com.stasl.giphyapp.gif.GIF;

public class ListAdapter extends BaseAdapter
{
    private Context context;
    private GIF gifs;
    private LayoutInflater layoutInflater;

    public ListAdapter(Context context, GIF gifs)
    {
        this.context = context;
        this.gifs = gifs;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gifs.getData().length;
    }

    @Override
    public Object getItem(int position) {
        return gifs.getData()[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        if (view == null)
        {
            view = layoutInflater.inflate(R.layout.gif_list_layout, parent, false);
        }
        Data gif = (Data) getItem(position);
        ImageView image = (ImageView)view.findViewById(R.id.imageView);
        view.findViewById(R.id.imageView2).setTag(gif.getImages().getOriginal().getUrl() + ";" + gif.getTrending_datetime());
        Glide.with(context)
                .load(gif.getImages().getPreview_gif().getUrl())
                .asGif()
                .placeholder(R.drawable.ic_cached_black_48dp)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
        view.findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Image clicked", v.findViewById(R.id.imageView2).getTag().toString());
                Intent intent = new Intent(context, ImageViewActivity.class);
                intent.putExtra("imageURL", v.findViewById(R.id.imageView2).getTag().toString());
                context.startActivity(intent);
            }
        });
        return view;
    }
}
