package com.example.asynctask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        val number: TextView = findViewById(R.id.numberTextView)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val loader = Loading(number, context)
            loader.execute()
        }
    }
}