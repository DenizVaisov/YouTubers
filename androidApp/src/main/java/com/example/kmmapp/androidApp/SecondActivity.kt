package com.example.kmmapp.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun userInfo(view: View){
        val intent = Intent(this, MainActivity::class.java)
        val login = findViewById<EditText>(R.id.log)
        val password = findViewById<EditText>(R.id.pass)
        val checkInputs = findViewById<TextView>(R.id.check)

        intent.putExtra("login", login.text.toString())
        intent.putExtra("password", password.text.toString())

        when {
            login.text.toString() == "" -> checkInputs.text = "Введите логин"
            password.text.toString() == "" -> checkInputs.text = "Введите пароль"
            else -> {
                startActivity(intent)
            }
        }
    }
}