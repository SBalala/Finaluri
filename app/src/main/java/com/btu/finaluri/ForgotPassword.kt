package com.btu.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val button4 = findViewById<Button>(R.id.button4)
        val editEmail = findViewById<EditText>(R.id.editEmail)


        button4.setOnClickListener {

            val email = editEmail.text.toString()

            if(email.isNotEmpty()){


                FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                        task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "New Password Link Sent", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "User not found!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            finish()
        }
    }
}