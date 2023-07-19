package com.example.recipeassignment;

import android.os.Bundle;
;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Recipe> recipes;
    private RecyclerView rcView;
    private RecipeAdapter adapter;
    public static final String EXTRA_REPLY = "com.example.recipeassignment.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        recipes = DataProvider.getRecipes();

        rcView = findViewById(R.id.recyclerview);

        adapter = new RecipeAdapter(this, recipes);

        rcView.setAdapter(adapter);

        rcView.setLayoutManager(new LinearLayoutManager(this));
    }




}