package com.btu.finaluri.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.btu.finaluri.ChangePasswordActivity
import com.btu.finaluri.MainActivity
import com.btu.finaluri.R
import com.btu.finaluri.UserInfo
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val user = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textView = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val button = view.findViewById<Button>(R.id.button)
        val change = view.findViewById<Button>(R.id.change)
        val logout = view.findViewById<Button>(R.id.logout)

        button.setOnClickListener {
            val dialog = UpFragment()
            dialog.show(childFragmentManager, "custom")


        }
        change.setOnClickListener {
            startActivity(Intent(this@ProfileFragment.requireContext(), ChangePasswordActivity::class.java))

        }
        logout.setOnClickListener {
            user.signOut()
            startActivity(Intent(this@ProfileFragment.requireContext(), MainActivity::class.java))
        }

        db.child(user.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo = snapshot.getValue(UserInfo::class.java) ?: return
                textView.text = userInfo.name
                val img = userInfo.url

                Glide.with(this@ProfileFragment)
                    .load(img)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_baseline_person_24)
                    .into(imageView)

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


}