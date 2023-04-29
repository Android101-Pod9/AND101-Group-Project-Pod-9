package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var userInput: EditText
    private lateinit var passInput: EditText
    private lateinit var signupButton: Button
    lateinit var toLogin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)


        userInput = findViewById(R.id.userInput)
        passInput = findViewById(R.id.passInput)
        signupButton = findViewById(R.id.signupButton)
        toLogin = findViewById(R.id.toLogin)
        firebaseAuth = Firebase.auth


        signupButton.setOnClickListener {
            signupUser()
        }

        toLogin.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }


    private fun signupUser() {
        val username = userInput.text.toString()
        val password = passInput.text.toString()


        if(username.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Fields cannot be left blank.", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(this) {
            if(it.isSuccessful) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Signup Failed.", Toast.LENGTH_SHORT).show()
            }
        }

    }


}