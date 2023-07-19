package com.example.colors;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText redChannelEditText;
    private TextInputEditText greenChannelEditText;
    private TextInputEditText blueChannelEditText;
    private Button submitButton;
    private View colorView;
    private TextView colorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redChannelEditText = findViewById(R.id.redChannelEditText);
        greenChannelEditText = findViewById(R.id.greenChannelEditText);
        blueChannelEditText = findViewById(R.id.blueChannelEditText);
        submitButton = findViewById(R.id.submitButton);
        colorView = findViewById(R.id.colorView);
        colorTextView = findViewById(R.id.colorTextView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String redChannel = redChannelEditText.getText().toString();
                String greenChannel = greenChannelEditText.getText().toString();
                String blueChannel = blueChannelEditText.getText().toString();

                // Validate input
                if (redChannel.length() != 2 || greenChannel.length() != 2 || blueChannel.length() != 2) {
                    Toast.makeText(MainActivity.this, "Invalid color input", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert input to color
                String colorString = "#" + redChannel + greenChannel + blueChannel;
                int color;
                try {
                    color = Color.parseColor(colorString);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(MainActivity.this, "Invalid color input", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Update color view
                colorView.setBackgroundColor(color);

                // Update color text
                colorTextView.setText("Color: " + colorString);
            }
        });
    }
}
