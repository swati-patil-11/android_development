package com.example.change_background;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Main layout
        View layout = findViewById(R.id.main);

        // Buttons
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        // Click events
        btn1.setOnClickListener(v -> layout.setBackgroundResource(R.drawable.bg1));
        btn2.setOnClickListener(v -> layout.setBackgroundResource(R.drawable.bg2));
        btn3.setOnClickListener(v -> layout.setBackgroundResource(R.drawable.bg3));
    }
}