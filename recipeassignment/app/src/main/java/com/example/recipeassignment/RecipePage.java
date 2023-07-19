package com.example.recipeassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class RecipePage extends AppCompatActivity {

    //Views to bind to
    public String position;
    public TextView title;
    public ImageView imgageView;
    public TextView scroll;

    /**
     * On Create method for the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setup our views
        imgageView = findViewById(R.id.recipeImage);
        title = findViewById(R.id.recipeName);
        scroll = findViewById(R.id.recipeStepsText);

        //Get the data from the intent
        Intent intent = getIntent();
        position = intent.getStringExtra(MainActivity.EXTRA_REPLY);
        loadRecipe(position);
    }

    /**
     * Takes in the position for the recipe in the list, and uses it to bind its data to the view
     * @param position Position in the list for this recipe
     */
    private void loadRecipe(String position){
        int pos = Integer.parseInt(position);
        Recipe recipe = DataProvider.getRecipes().get(pos);
        title.setText(recipe.name);
        scroll.setText(recipe.ingredients + "\n\n" + recipe.directions);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imgageView);
    }



}