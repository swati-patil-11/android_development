package com.example.widgets6th;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.widgets6th.R;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    RadioGroup radioGroup;
    CheckBox cbAgree;
    ToggleButton toggleStatus;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI components
        etName = findViewById(R.id.etName);
        radioGroup = findViewById(R.id.radioGroup);
        cbAgree = findViewById(R.id.cbAgree);
        toggleStatus = findViewById(R.id.toggleStatus);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Button Click Event
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();

                // Get selected Radio Button
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedId);
                String gender = (rb != null) ? rb.getText().toString() : "Not selected";

                // CheckBox status
                boolean isChecked = cbAgree.isChecked();

                // Toggle status
                String status = toggleStatus.isChecked() ? "Active" : "Inactive";

                // Validation
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isChecked) {
                    Toast.makeText(MainActivity.this, "Please agree to terms", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Display Output
                String result = "Name: " + name +
                        "\nGender: " + gender +
                        "\nStatus: " + status;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}