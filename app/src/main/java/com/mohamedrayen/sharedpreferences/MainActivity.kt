package com.mohamedrayen.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var savedText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextText)
        savedText = findViewById(R.id.textView2)
        val Btn = findViewById<Button>(R.id.button)
        showStoredInfo()
        Btn.setOnClickListener {
            val savedText : String = editText.text.toString()
            saveInfoData(savedText)
            showStoredInfo()
        }
    }

    private fun saveInfoData(savedText: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
        val save_some_text: SharedPreferences.Editor = sharedPreferences.edit()
        save_some_text.putString("name", savedText).commit()
    }

    private fun showStoredInfo() {
        savedText
        val sharedPreferences : SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
        val text1 : String? = sharedPreferences.getString("name","")
        savedText.setText(text1)
    }
}