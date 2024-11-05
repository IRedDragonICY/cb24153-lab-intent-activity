package com.ireddragonicy.labintentactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;

public class BActivity extends ComponentActivity {

    private TextView receivedInfoTextView;
    private EditText sendInfoEditText;
    private Button replyMainButton;
    private Button sendToCButton;
    private Button homeButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bactivity);

        initializeViews();
        displayReceivedMessage();
        setClickListeners();
    }

    private void initializeViews() {
        receivedInfoTextView = findViewById(R.id.textView5);
        sendInfoEditText = findViewById(R.id.editText2);
        replyMainButton = findViewById(R.id.button5);
        sendToCButton = findViewById(R.id.button6);
        homeButton = findViewById(R.id.button3);
        backButton = findViewById(R.id.button4);
    }

    private void displayReceivedMessage() {
        String message = getIntent().getStringExtra("messageToB");
        if (message != null) {
            receivedInfoTextView.setText(message);
        }
    }

    private void setClickListeners() {
        replyMainButton.setOnClickListener(view -> {
            String replyMessage = sendInfoEditText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("replyMessage", replyMessage);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });

        sendToCButton.setOnClickListener(view -> {
            String messageToC = sendInfoEditText.getText().toString();
            Intent intent = new Intent(BActivity.this, CActivity.class);
            intent.putExtra("messageToC", messageToC);
            startActivity(intent);
        });

        homeButton.setOnClickListener(view -> {
            Intent intent = new Intent(BActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        backButton.setOnClickListener(view -> finish());
    }
}
