package com.example.tdd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> itemList;
    private ArrayAdapter<String> adapter;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            number = extras.getInt("number");
        }

        generateItems();
        setItemClickListeners();
    }

    private void generateItems() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                if (count < number) {
                    String item = "Item " + count;
                    itemList.add(item);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                    count++;
                } else {
                    timer.cancel();
                }
            }
        }, 1000, 1000);
    }

    private void setItemClickListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
            }
        });
    }
}


