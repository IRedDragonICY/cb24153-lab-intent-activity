package com.ireddragonicy.labintentactivity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : ComponentActivity() {

    private lateinit var editText: EditText
    private lateinit var receivedInfoTextView: TextView
    private lateinit var sendToBButton: Button
    private lateinit var sendToCButton: Button
    private lateinit var implicitActivityButton: Button

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        initializeViews()
        setupActivityResultLauncher()
        setClickListeners()
    }

    private fun initializeViews() {
        editText = findViewById(R.id.editText)
        receivedInfoTextView = findViewById(R.id.textView3)
        sendToBButton = findViewById(R.id.button)
        sendToCButton = findViewById(R.id.button2)
        implicitActivityButton = findViewById(R.id.button11)
    }

    private fun setupActivityResultLauncher() {
        startForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.getStringExtra("replyMessage")?.let { message ->
                    receivedInfoTextView.text = message
                }
            }
        }
    }

    private fun setClickListeners() {
        sendToBButton.setOnClickListener {
            val message = editText.text.toString()
            val intent = Intent(this, BActivity::class.java).apply {
                putExtra("messageToB", message)
            }
            startForResult.launch(intent)
        }

        sendToCButton.setOnClickListener {
            val message = editText.text.toString()
            val intent = Intent(this, CActivity::class.java).apply {
                putExtra("messageToC", message)
            }
            startActivity(intent)
        }

        implicitActivityButton.setOnClickListener {
            val intent = Intent(this, MyImplicitIntent::class.java)
            startActivity(intent)
        }
    }
}
