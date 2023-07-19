package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    private TableLayout orderTable;
    private TextView totalText;
    private RadioGroup drinkSizeRadioGroup;
    private Button backButton;
    private Button clearOrderButton;

    private ArrayList<String> orderedItems = new ArrayList<>();
    private ArrayList<Double> itemPrices = new ArrayList<>();
    private boolean drinkSelected = false;
    private double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        orderTable = findViewById(R.id.order_table);
        totalText = findViewById(R.id.total_text);
        drinkSizeRadioGroup = findViewById(R.id.drink_size_radio_group);
        backButton = findViewById(R.id.back_button);
        clearOrderButton = findViewById(R.id.clear_order_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        clearOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderedItems.clear();
                itemPrices.clear();
                drinkSelected = false;
                total = 0.0;
                updateOrderTable();
                updateTotal();
            }
        });

        drinkSizeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.small_radio:
                        if (drinkSelected) {
                            total -= 1.0;
                        } else {
                            drinkSelected = true;
                        }
                        total += 1.0;
                        break;
                    case R.id.medium_radio:
                        if (drinkSelected) {
                            total -= 1.5;
                        } else {
                            drinkSelected = true;
                        }
                        total += 1.5;
                        break;
                    case R.id.large_radio:
                        if (drinkSelected) {
                            total -= 2.0;
                        } else {
                            drinkSelected = true;
                        }
                        total += 2.0;
                        break;
                }
                updateTotal();
            }
        });
    }

    private void updateOrderTable() {
        orderTable.removeAllViews();
        for (int i = 0; i < orderedItems.size(); i++) {
            TableRow row = new TableRow(this);
            TextView itemText = new TextView(this);
            itemText.setText(orderedItems.get(i));
            TextView priceText = new TextView(this);
            priceText.setText(String.valueOf(itemPrices.get(i)));
            row.addView(itemText);
            row.addView(priceText);
            orderTable.addView(row);
        }
    }

    private void updateTotal() {
        totalText.setText("Total: $" + String.valueOf(total));
    }
}
