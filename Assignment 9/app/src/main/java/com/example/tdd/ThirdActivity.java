package com.example.tdd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent.hasExtra("selectedItem")) {
            String selectedItem = intent.getStringExtra("selectedItem");
            textView.setText("You clicked " + selectedItem);
        }
    }
}

