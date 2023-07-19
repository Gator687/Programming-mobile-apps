package com.example.modulenineassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int number = getIntent().getIntExtra("number", 0);
        generateItemList(number);

        adapter = new MyAdapter(itemList, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void generateItemList(int number) {
        itemList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            itemList.add("Item " + i);
        }
    }
}
