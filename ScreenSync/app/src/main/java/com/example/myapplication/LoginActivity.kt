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
    lateinit var guest: Button
    lateinit var toSignUp: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)


        userInput = findViewById(R.id.userInput)
        passInput = findViewById(R.id.passInput)
        loginButton = findViewById(R.id.loginButton)
        toSignUp = findViewById(R.id.toSignUp)
        guest = findViewById(R.id.guest)

        firebaseAuth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener() {
            loginUser()
        }

        toSignUp.setOnClickListener() {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)


        }


        guest.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


        guest.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }




    }


    private fun loginUser() {
        val username = userInput.text.toString()
        val password = passInput.text.toString()


        if(username.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Fields cannot be left blank.", Toast.LENGTH_SHORT).show()
        }


        firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(this) {
            if(it.isSuccessful) {


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()







                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()




            } 
            else {

                Toast.makeText(this, "Login Failed.", Toast.LENGTH_SHORT).show()
            }

        }
    }



}