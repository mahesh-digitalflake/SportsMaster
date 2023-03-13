package com.example.sportsmaster

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import com.example.sportsmaster.databinding.ActivityLoginBinding
import com.example.sportsmaster.databinding.ActivityRegisterationBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListner()
        passwordFocusListner()



        binding.backBtnImg.setOnClickListener {
//            val intent=Intent(this,MainActivity::class.java)
//            startActivity(intent)
            finish()
        }

        binding.registerNow.setOnClickListener {
            val intent = Intent(this, RegisterationActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.forgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
            finish()
//            val intent = Intent(this, HomeActivity::class.java)
//           startActivity(intent)
        }

        binding.loginBtn.setOnClickListener {

            submitForm()

        }


    }

    private fun submitForm() {
        if(binding.email.text?.trim().isNullOrEmpty() || binding.password.text?.trim().isNullOrEmpty())
        {
            Toast.makeText(this,"Please Enter All Fields", Toast.LENGTH_LONG).show()
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(binding.email.text).matches() &&
            binding.password.text?.trim()?.length!!<8)
        {
            Toast.makeText(this,"Please Enter valid data", Toast.LENGTH_LONG).show()

        }
        else {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun emailFocusListner() {
        binding.email.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.lgEmailParent.helperText = validEmail()
            }
        }

    }

    private fun validEmail(): String? {
        val email=binding.email.text?.trim().toString()
        if(email.isEmpty())
        {
            return "Please Enter Email"
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusListner() {
        binding.password.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.lgPasswordParent.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val password= binding.password.text?.trim().toString()
        if(password.isEmpty())
        {
            return "Please Enter Password"
        }
        if(password.length<8)
        {
            return "Minimum 8 Characters Password Required"
        }
        if(!password.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 UpperCase Characters"
        }
        if(!password.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 LowerCase Characters"
        }
        if(!password.matches(".*[@#$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Characters (@#\$%^&+=)"
        }
        return null
    }
}