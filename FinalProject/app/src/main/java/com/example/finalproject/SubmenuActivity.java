package com.example.finalproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubmenuActivity extends AppCompatActivity {

    private GridView foodGridView;
    private TextView selectedItemText;
    private ImageView selectedItemImage;
    private Button backButton;
    private Button addToOrderButton;

    private String[] foodItems = {"Food 1", "Food 2", "Food 3", "Food 4"};
    private int[] foodImages = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4};

    private String menuType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submenu);

        menuType = getIntent().getStringExtra("menuType");

        TextView submenuTitle = findViewById(R.id.submenu_title);
        submenuTitle.setText(menuType);

        foodGridView = findViewById(R.id.food_grid);
        FoodAdapter foodAdapter = new FoodAdapter(this, foodItems, foodImages);
        foodGridView.setAdapter(foodAdapter);

        selectedItemText = findViewById(R.id.selected_item_text);
        selectedItemImage = findViewById(R.id.selected_item_image);
        backButton = findViewById(R.id.back_button);
        addToOrderButton = findViewById(R.id.add_to_order_button);

        foodGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = foodItems[position];
                selectedItemText.setText(selectedItem);
                selectedItemImage.setImageResource(foodImages[position]);
                addToOrderButton.setEnabled(true);
            }
        });

        addToOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = selectedItemText.getText().toString();
                Toast.makeText(SubmenuActivity.this, selectedItem + " has been added to your order", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
