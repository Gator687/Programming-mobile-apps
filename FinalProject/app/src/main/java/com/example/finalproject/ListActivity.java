package com.example.finalproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    private ListView menuListView;

    private String[] menuItems = {"Breakfast", "Lunch", "Dinner", "Desserts", "My Order"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        menuListView = findViewById(R.id.menu_list);
        MenuAdapter menuAdapter = new MenuAdapter(this, menuItems);
        menuListView.setAdapter(menuAdapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        openSubMenu("Breakfast");
                        break;
                    case 1:
                        openSubMenu("Lunch");
                        break;
                    case 2:
                        openSubMenu("Dinner");
                        break;
                    case 3:
                        openSubMenu("Desserts");
                        break;
                    case 4:
                        openMyOrder();
                        break;
                }
            }
        });
    }

    private void openSubMenu(String menuType) {
        Intent intent = new Intent(this, SubmenuActivity.class);
        intent.putExtra("menuType", menuType);
        startActivity(intent);
    }

    private void openMyOrder() {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}
