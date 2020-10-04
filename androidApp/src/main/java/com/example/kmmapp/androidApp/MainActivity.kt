package com.example.kmmapp.androidApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.kmmapp.bloggers.BloggerActivity
import com.example.kmmapp.users.User

class MainActivity : AppCompatActivity() {
    var users: MutableList<User> = mutableListOf(User("Deniz", "428069dv"))

    private fun checkLogIn(){
        val login = findViewById<EditText>(R.id.login)
        val password = findViewById<EditText>(R.id.password)
        val checkInputs = findViewById<TextView>(R.id.checkMain)
        val intent = Intent(this, BloggerActivity::class.java)
        when {
            login.text.toString() == "" -> checkInputs.text = "Введите логин"
            password.text.toString() == "" -> checkInputs.text = "Введите пароль"
            else -> {
                startActivity(intent)
            }
        }
    }

    private fun logIn(){
        val regButton = findViewById<TextView>(R.id.regView)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val login = findViewById<EditText>(R.id.login)
        val password = findViewById<EditText>(R.id.password)
        val checkInputs = findViewById<TextView>(R.id.checkMain)

        val loginReg = intent.getStringExtra("login").toString()
        val passReg = intent.getStringExtra("password").toString()

        users.add(User(loginReg, passReg))

        signInButton.setOnClickListener{view ->
            val intent = Intent(this, BloggerActivity::class.java)
            checkLogIn()
            if(users.contains(User(login.text.toString(), password.text.toString()))) {
                startActivity(intent)
            }
            else {
                checkInputs.text = "Пользователь не найден"
            }
        }
        regButton.setOnClickListener {view ->
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logIn()
    }
}
