package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ForgetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        val forgBackBtnImg=findViewById<ImageView>(R.id.forgBackBtnImg)
        val sendCodeBtn=findViewById<Button>(R.id.sendCodeBtn)
        forgBackBtnImg.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        sendCodeBtn.setOnClickListener {
            val intent=Intent(this,NewPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}