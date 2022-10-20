package com.gl4.tp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtEmail: EditText
    lateinit var txtPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editTextTextEmailAddress2)
        txtPassword = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.button)
        btnLogin.setOnClickListener { view ->
            if (view?.id == R.id.button) {
                if (txtEmail.text.toString() == "gl4@insat.tn" && txtPassword.text.toString() == "insat2022") {
                    val text = "Félicitations! Vous êtes connecté"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra("email", txtEmail.text.toString())
                    startActivity(intent)
                } else {
                    val text = "Email: ${txtEmail.text} et/ou mot de passe ${txtPassword.text} est incorrecte"
                    val duration = Toast.LENGTH_SHORT
                    val toast = Toast.makeText(applicationContext,text, duration)
                    toast.show()
                }

            }
        }
    }
}