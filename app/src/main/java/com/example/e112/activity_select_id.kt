package com.example.e112

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_select_id : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_select_id)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Handle the Spinner
        val spinner: Spinner = findViewById(R.id.spinner_document_type)
        // Create an ArrayAdapter using the string array from strings.xml
        val documentTypes = resources.getStringArray(R.array.document_types_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, documentTypes)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter

        // 2. Handle the "NEXT" button click
        val nextButton: Button = findViewById(R.id.button_next)
        nextButton.setOnClickListener {
            // Navigate to the next screen (e.g., the fingerprint verification screen)
            val intent = Intent(this, VerifyEmergencyActivity::class.java)
            startActivity(intent)
        }

        // 3. Handle the "Upload your document" button click
        val uploadButton: Button = findViewById(R.id.button_upload_document)
        uploadButton.setOnClickListener {
            // Here you'll add the code to open a file picker
            // For now, it can be a placeholder
            // For example:
            // openFilePicker()
        }
    }
}