package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        val crtResetBtn=findViewById<Button>(R.id.crtResetBtn)
        crtResetBtn.setOnClickListener {
            val intent=Intent(this,PasswordChangedActivity::class.java)
            startActivity(intent)
        }
    }
}