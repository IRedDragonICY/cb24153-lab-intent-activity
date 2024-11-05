package com.ireddragonicy.labintentactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;

public class CActivity extends ComponentActivity {

    private TextView receivedInfoTextView;
    private Button homeButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cactivity);

        initializeViews();
        displayReceivedMessage();
        setClickListeners();
    }

    private void initializeViews() {
        receivedInfoTextView = findViewById(R.id.textView8);
        homeButton = findViewById(R.id.button7);
        backButton = findViewById(R.id.button8);
    }

    private void displayReceivedMessage() {
        String message = getIntent().getStringExtra("messageToC");
        if (message != null) {
            receivedInfoTextView.setText(message);
        }
    }

    private void setClickListeners() {
        homeButton.setOnClickListener(view -> {
            Intent intent = new Intent(CActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        backButton.setOnClickListener(view -> finish());
    }
}
