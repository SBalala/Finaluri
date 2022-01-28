package com.btu.finaluri

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.loginbutton)
        val register = findViewById<Button>(R.id.registerbutton)
        val forgotpass = findViewById<TextView>(R.id.forgotpassword)

        login.setOnClickListener {
//
            login()
        }

        register.setOnClickListener {
            startActivity(Intent(this, Registration::class.java))
        }

        forgotpass.setOnClickListener {
            startActivity(Intent(this, ForgotPassword::class.java))
        }

    }

    private fun login(){
        val emailAdress = findViewById<EditText>(R.id.emailAddress)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val email = emailAdress.text.toString()
        val pass = editPassword.text.toString()

        if(email.isNotEmpty() && pass.isNotEmpty()){
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->



                    if (task.isSuccessful){
                        startActivity(Intent(this, MainActivity2::class.java))
                        finish()
                    } else {
                        Toast.makeText(this,"Account Not Found", Toast.LENGTH_SHORT).show()


                    }

                }
        }}


}