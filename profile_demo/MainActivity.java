package com.example.profile_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goLogin = findViewById(R.id.gologin);

        goLogin.setOnClickListener(v -> {

            Intent i = getPackageManager()
                    .getLaunchIntentForPackage("com.example.loginpage"); // make sure package is correct

            if (i != null) {
                startActivity(i);
            } else {
                Toast.makeText(this, "Login App Not Installed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}