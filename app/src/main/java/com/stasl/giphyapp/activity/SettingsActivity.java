package com.stasl.giphyapp.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.stasl.giphyapp.R;

public class SettingsActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
