package com.ireddragonicy.labintentactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var editText: EditText
    private lateinit var receivedInfoTextView: TextView
    private lateinit var sendToBButton: Button
    private lateinit var sendToCButton: Button
    private lateinit var implicitActivityButton: Button

    companion object {
        const val REQUEST_CODE_B = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        initializeViews()
        handleIncomingIntent()
        setClickListeners()
    }

    private fun initializeViews() {
        editText = findViewById(R.id.editText)
        receivedInfoTextView = findViewById(R.id.textView3)
        sendToBButton = findViewById(R.id.button)
        sendToCButton = findViewById(R.id.button2)
        implicitActivityButton = findViewById(R.id.button11)
    }

    private fun handleIncomingIntent() {
        intent.getStringExtra("replyMessage")?.let { message ->
            receivedInfoTextView.text = message
        }
    }

    private fun setClickListeners() {
        sendToBButton.setOnClickListener {
            val message = editText.text.toString()
            val intent = Intent(this, BActivity::class.java).apply {
                putExtra("messageToB", message)
            }
            startActivityForResult(intent, REQUEST_CODE_B)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_B && resultCode == RESULT_OK) {
            data?.getStringExtra("replyMessage")?.let { message ->
                receivedInfoTextView.text = message
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
