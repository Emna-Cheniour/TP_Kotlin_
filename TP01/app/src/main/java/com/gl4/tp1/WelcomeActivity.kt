package com.gl4.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    lateinit var txtWelcome: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcoming)
        val email = intent.getStringExtra("email")
        txtWelcome = findViewById(R.id.textView)
        txtWelcome.text = "Bienvenue $email"
    }
}