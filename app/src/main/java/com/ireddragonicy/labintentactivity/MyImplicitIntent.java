package com.ireddragonicy.labintentactivity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyImplicitIntent extends Activity {

    private EditText inputEditText;
    private Button searchButton;
    private Button smsButton;
    private Button callButton;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myimplicitintentactivity);

        initializeViews();
        setClickListeners();
    }

    private void initializeViews() {
        inputEditText = findViewById(R.id.et1);
        searchButton = findViewById(R.id.button);
        smsButton = findViewById(R.id.button2);
        callButton = findViewById(R.id.button10);
        homeButton = findViewById(R.id.button9);
    }

    private void setClickListeners() {
        searchButton.setOnClickListener(view -> performWebSearch());
        smsButton.setOnClickListener(view -> sendSms());
        callButton.setOnClickListener(view -> makePhoneCall());
        homeButton.setOnClickListener(view -> navigateHome());
    }

    private void performWebSearch() {
        String query = inputEditText.getText().toString();
        if (!query.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, query);
            startActivitySafely(intent);
        }
    }

    private void sendSms() {
        String phoneNumber = inputEditText.getText().toString();
        if (!phoneNumber.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
            startActivitySafely(intent);
        }
    }

    private void makePhoneCall() {
        String phoneNumber = inputEditText.getText().toString();
        if (!phoneNumber.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivitySafely(intent);
        }
    }

    private void navigateHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void startActivitySafely(Intent intent) {
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No application can handle this request", Toast.LENGTH_SHORT).show();
        }
    }
}
