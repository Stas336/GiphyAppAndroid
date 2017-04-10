package com.stasl.giphyapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.stasl.giphyapp.R;
import com.stasl.giphyapp.adapter.ListAdapter;
import com.stasl.giphyapp.gif.GIF;

import java.util.concurrent.ExecutionException;

public class SearchActivity extends AppCompatActivity
{
    private String contentType = "y"; // g,pg
    private String term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        term = getIntent().getStringExtra("term");
        getSupportActionBar().setTitle(term);
        search(term);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_search, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                return true;
            case R.id.action_contentType:
                switch (contentType) {
                    case "y":
                        contentType = "g";
                        item.setIcon(getResources().getDrawable(R.mipmap.g));
                        search(term);
                        break;
                    case "g":
                        contentType = "pg";
                        item.setIcon(getResources().getDrawable(R.mipmap.pg));
                        search(term);
                        break;
                    case "pg":
                        contentType = "y";
                        item.setIcon(getResources().getDrawable(R.mipmap.y));
                        search(term);
                        break;
                }
        }
        return super.onOptionsItemSelected(item);
    }
    private void search(String term)
    {
        GIF gifs = null;
        try {
            gifs = MainActivity.search(term, contentType);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new ListAdapter(this, gifs);
        ListView list = (ListView)findViewById(R.id.List);
        list.setAdapter(adapter);
    }
}