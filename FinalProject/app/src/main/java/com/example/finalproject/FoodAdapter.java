package com.example.finalproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] foodItems;
    private int[] foodImages;

    public FoodAdapter(Context context, String[] foodItems, int[] foodImages) {
        super(context, 0, foodItems);
        this.context = context;
        this.foodItems = foodItems;
        this.foodImages = foodImages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
        }

        TextView foodItemText = listItemView.findViewById(R.id.food_item_text);
        ImageView foodItemImage = listItemView.findViewById(R.id.food_item_image);

        foodItemText.setText(foodItems[position]);
        foodItemImage.setImageResource(foodImages[position]);

        return listItemView;
    }
}