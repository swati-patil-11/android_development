package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
    }

    public void calculate(View view) {

        int a = Integer.parseInt(num1.getText().toString());
        int b = Integer.parseInt(num2.getText().toString());

        Button btn = (Button) view;
        String op = btn.getText().toString();

        int ans = 0;

        if(op.equals("+")) ans = a + b;
        if(op.equals("-")) ans = a - b;
        if(op.equals("*")) ans = a * b;
        if(op.equals("/")) ans = a / b;

        result.setText("Result: " + ans);
    }
}
