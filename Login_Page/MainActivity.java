package com.example.loginpage;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.loginBtn);

        login.setOnClickListener(v -> {

            if(username.getText().toString().equals("swati") &&
                    password.getText().toString().equals("1234")) {
                

                Intent i = getPackageManager()
                        .getLaunchIntentForPackage("com.example.profile_demo");

                startActivity(i);

            } else {
                Toast.makeText(this, "Wrong Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}