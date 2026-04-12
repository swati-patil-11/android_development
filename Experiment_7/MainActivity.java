package com.example.exp7th;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView tvRating;
    EditText etFeedback;
    ProgressBar progressBar;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        tvRating = findViewById(R.id.tvRating);
        etFeedback = findViewById(R.id.etFeedback);
        progressBar = findViewById(R.id.progressBar);
        btnSubmit = findViewById(R.id.btnSubmit);


        ratingBar.setOnRatingBarChangeListener((rb, rating, fromUser) -> {
            tvRating.setText("Rating: " + rating);
        });


        btnSubmit.setOnClickListener(v -> {

            float rating = ratingBar.getRating();
            String feedback = etFeedback.getText().toString();

            // Simple validation
            if (rating == 0) {
                Toast.makeText(this, "Give rating first", Toast.LENGTH_SHORT).show();
                return;
            }

            if (feedback.isEmpty()) {
                etFeedback.setError("Enter feedback");
                return;
            }

            // Show progress
            progressBar.setVisibility(View.VISIBLE);

            // Simulate delay (2 seconds)
            new Handler().postDelayed(() -> {

                progressBar.setVisibility(ProgressBar.GONE);

                Toast.makeText(this,
                        "Feedback Submitted!",
                        Toast.LENGTH_SHORT).show();

                // Reset
                ratingBar.setRating(0);
                etFeedback.setText("");
                tvRating.setText("Rating: 0");

            }, 4000); // 4 seconds delay
        });
    }
}