package com.example.modulenineassignment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textView = findViewById(R.id.textView);

        String item = getIntent().getStringExtra("item");
        Log.d("A", "TEST");
        if (item != null) {
            textView.setText("You clicked " + item);
        } else {
            textView.setText("No item clicked");
        }
    }
}
