package com.example.recipeassignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    //Class Variables
    private final LinkedList<Recipe> mRecipes;
    private final LayoutInflater mInflater;
    private Context context;
    public int position;


    /**
     * RecipeViewHolder Class
     */
    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Class Variables
        public final TextView title;
        public final TextView description;
        private RecipeAdapter adapter;
        private final CardView card;

        /**
         * Constructor for the Recipe View Holder
         * @param itemView The View
         * @param adapter The data adapter
         */
        public RecipeViewHolder(View itemView, RecipeAdapter adapter) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            card = itemView.findViewById(R.id.cv);
            itemView.setOnClickListener(this);
            this.adapter = adapter;

        }

        /**
         * On click method for the RecipeViewHolder
         * @param view
         */
        @Override
        public void onClick(View view) {
            position = getAdapterPosition();
            Intent intent = new Intent(context, RecipePage.class);
            String pos = Integer.toString(position);
            intent.putExtra(MainActivity.EXTRA_REPLY,pos);
            context.startActivity(intent);

        }
    }

    /**
     * Constructor for the RecipeAdapter
     * @param context
     * @param recipes
     */
    public RecipeAdapter(Context context, LinkedList<Recipe> recipes){
        mInflater = LayoutInflater.from(context);
        this.mRecipes = recipes;
        this.context = context;
    }


    /**
     * Creates a view holder for a specific item in the Dataset, and returns it to the view
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipe, viewGroup, false);
        return new RecipeViewHolder(mItemView, this);
    }


    /**
     * Binds the data to the ViewHolder
     * @param recipeViewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        Recipe recipe = mRecipes.get(i);
        recipeViewHolder.title.setText(recipe.name);
        recipeViewHolder.description.setText(recipe.description);
    }

    /**
     * Get the number of items in the dataset
     * @return
     */
    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
}
