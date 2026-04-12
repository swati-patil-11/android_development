package com.example.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageButton call,msg,wp;

    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        call = findViewById(R.id.call);
        msg = findViewById(R.id.msg);
        wp = findViewById(R.id.wp);

        number = getIntent().getStringExtra("phone");

        if(number != null){
            textView.setText(number);
        }

        call.setOnClickListener(v -> {

            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + number));
            startActivity(i);

        });

        msg.setOnClickListener(v -> {

            String cleanNumber = number.replace(" ", "").replace("+", "");

            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("smsto:" + cleanNumber));
            startActivity(i);

        });

        wp.setOnClickListener(v -> {

            String wpNumber = number.replace(" ","").replace("+","");

            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://wa.me/" + wpNumber));
            startActivity(i);

        });
    }
}