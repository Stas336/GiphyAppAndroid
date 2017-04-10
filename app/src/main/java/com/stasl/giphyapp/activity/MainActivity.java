package com.stasl.giphyapp.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.stasl.giphyapp.R;
import com.stasl.giphyapp.adapter.ListAdapter;
import com.stasl.giphyapp.api.GiphyAPI;
import com.stasl.giphyapp.gif.GIF;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private static final String BASE_URL = "http://api.giphy.com/";
    private static final String PUBLIC_API_KEY = "dc6zaTOxFJmzC";
    private static int IMAGES_LIMIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        IMAGES_LIMIT = Integer.valueOf(getPrefs.getString("imagesLimit", "10"));
        showTrending();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.d("SearchSubmit", query);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.putExtra("term", query);
        startActivity(intent);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_exit:
                android.os.Process.killProcess(android.os.Process.myPid());
                return true;
            case R.id.action_settings:
                Intent modifySettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(modifySettings);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static GiphyAPI getAPI()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GiphyAPI.class);
    }

    private static class GiphyGetTrendingGifs extends AsyncTask<Void, Void, GIF>
    {
        @Override
        protected GIF doInBackground(Void... voids) {
            GiphyAPI api = getAPI();
            Response<GIF> response = null;
            try {
                response = api.getTrendingGifs(PUBLIC_API_KEY, IMAGES_LIMIT).execute();
            } catch (IOException e) {
                Log.d("GetTrending", e.getLocalizedMessage());
            }
            if (response == null)
            {
                return null;
            }
            else
            {
                return response.body();
            }
        }
    }
    private static class GiphySearchGifs extends AsyncTask<String, Void, GIF>
    {
        @Override
        protected GIF doInBackground(String... params) {
            GiphyAPI api = getAPI();
            Response<GIF> response = null;
            try {
                response = api.searchGifs(params[0], PUBLIC_API_KEY, IMAGES_LIMIT, params[1]).execute();
            } catch (IOException e) {
                Log.d("Search", e.getLocalizedMessage());
            }
            if (response == null)
            {
                return null;
            }
            else
            {
                return response.body();
            }
        }
    }
    public static GIF getTrending() throws ExecutionException, InterruptedException {
        GiphyGetTrendingGifs giphyGetTrending = new GiphyGetTrendingGifs();
        giphyGetTrending.execute();
        return giphyGetTrending.get();
    }
    public static GIF search(String term, String rating) throws ExecutionException, InterruptedException {
        GiphySearchGifs giphySearchGifs = new GiphySearchGifs();
        giphySearchGifs.execute(term, rating);
        return giphySearchGifs.get();
    }
    private void showTrending()
    {
        GIF gifs = null;
        try {
            gifs = getTrending();
        } catch (ExecutionException | InterruptedException e) {
            Log.d("getTrendingException", e.getLocalizedMessage());
            finish();
        }
        ListAdapter adapter = new ListAdapter(this, gifs);
        ListView list = (ListView)findViewById(R.id.List);
        list.setAdapter(adapter);
    }
}
