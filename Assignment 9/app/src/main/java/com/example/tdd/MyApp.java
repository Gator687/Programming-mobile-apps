package com.example.tdd;

import android.app.Application;

import androidx.test.espresso.IdlingResource;

public abstract class MyApp extends Application {
    private TextProvider textProvider;
    private ListLoader listLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        // Instantiate the dependencies
        textProvider = new TextProvider(getApplicationContext());
        listLoader = new ListLoader(null); // Pass the appropriate IdlingResource

        // Start using the dependencies in your activities
        Activity1.setTextProvider(textProvider);
        Activity2.setListLoader(listLoader);
        // ...
    }

    public abstract ListLoader getListLoader(IdlingResource idlingResource);
}

