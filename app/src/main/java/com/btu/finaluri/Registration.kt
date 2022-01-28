package com.btu.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val register = findViewById<Button>(R.id.Registration2Button)


//        val intent = Intent(this, )

        register.setOnClickListener {
            register()
        }

    }
    private fun register(){
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editPassword = findViewById<EditText>(R.id.editPassword)
        val editPassword2 = findViewById<EditText>(R.id.editPassword2)

        val email = editEmail.text.toString()
        val pass = editPassword.text.toString()
        val pass2 = editPassword2.text.toString()



        if (pass == pass2 && pass.length > 8 && pass.contains("[0-9]".toRegex()) && pass.contains("[a-z]".toRegex()) && email.contains("@") ){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }



            }}

    }
}