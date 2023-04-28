package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    lateinit var userInput: EditText
    private lateinit var passInput: EditText
    private lateinit var loginButton: Button
    lateinit var toSignUp: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)


        userInput = findViewById(R.id.userInput)
        passInput = findViewById(R.id.passInput)
        loginButton = findViewById(R.id.loginButton)
        toSignUp = findViewById(R.id.toSignUp)

        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener() {
            loginUser()
        }

        toSignUp.setOnClickListener() {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

            finish()
        }


    }


    private fun loginUser() {
        val username = userInput.text.toString()
        val password = passInput.text.toString()


        if(username.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Fields cannot be left blank.", Toast.LENGTH_SHORT).show()
        }


        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this) {
            if(it.isSuccessful) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Login Failed.", Toast.LENGTH_SHORT).show()
            }

        }
    }



}