package com.example.sportsmaster

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsmaster.databinding.ActivityMainBinding
import com.example.sportsmaster.databinding.ActivityRegisterationBinding
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegisterationActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListner()
        passwordFocusListner()
        confirmPasswordFocusListner()

        binding.registerBtn.setOnClickListener {

            submitForm()

        }

        binding.regBackBtnImg.setOnClickListener {
          val intent=Intent(this,LoginActivity::class.java)
           startActivity(intent)
           finish()
       }

        binding.regLoginNow.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun submitForm() {
        if(binding.regEmail.text?.trim().isNullOrEmpty() || binding.regPassword.text?.trim().isNullOrEmpty() || binding.regConfirmPassword.text?.trim()
                .isNullOrEmpty())
        {
            Toast.makeText(this,"Please Enter All Fields",Toast.LENGTH_LONG).show()

        }
        else if(!binding.regPassword.text.contentEquals(binding.regConfirmPassword.text))
        {
            Toast.makeText(this,"Confirm Password Missmatch",Toast.LENGTH_LONG).show()

        }
        else
        {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }

    }


    private fun emailFocusListner() {
        binding.regEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailParent.helperText = validEmail()
            }
//            if(binding.regEmail.text?.trim().toString().isEmpty())
//            {
//                binding.emailParent.helperText = validEmail()
//            }
        }
    }

    private fun validEmail(): String? {
        val regEmail= binding.regEmail.text?.trim().toString()
        if(regEmail.isEmpty())
        {
            return "Please Enter Email"
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(regEmail).matches())
        {
            return "Invalid Email Address"
        }
        return null
    }


    private fun passwordFocusListner() {
        binding.regPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordParent.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val regPassword= binding.regPassword.text?.trim().toString()
        if(regPassword.isEmpty())
        {
            return "Please Enter Password"
        }
        if(regPassword.length<8)
        {
            return "Minimum 8 Characters Password Required"
        }
        if(!regPassword.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 UpperCase Characters"
        }
        if(!regPassword.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 LowerCase Characters"
        }
        if(!regPassword.matches(".*[@#$%^&+=].*".toRegex()))
        {
            return "Must Contain 1 Special Characters (@#\$%^&+=)"
        }
        return null
    }

    private fun confirmPasswordFocusListner() {
        binding.regConfirmPassword.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.confirmPasswordParent.helperText = validConfirmPassword()
            }
        }
    }

    private fun validConfirmPassword(): String? {
        val regConfirmPassword= binding.regConfirmPassword.text?.trim().toString()
        if(regConfirmPassword.isEmpty())
        {
            return "Please Enter Confirm Password"
        }
        if(regConfirmPassword.length<8)
        {
            return "Minimum 8 Characters Password Required"
        }
        if(!regConfirmPassword.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 UpperCase Characters"
        }
        if(!regConfirmPassword.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 LowerCase Characters"
        }
        if(!regConfirmPassword.matches(".*[@#$%^&+=.].*".toRegex()))
        {
            return "Must Contain 1 Special Characters (@#\$%^&+=)"
        }
        return null
//        if(binding.regPassword.text.contentEquals(regConfirmPassword))
//        {
//            val intent=Intent(this,HomeActivity::class.java)
//            startActivity(intent)
//        }

    }

































    // binding.emailParent.boxBackgroundMode = TextInputLayout.BOX_BACKGROUND_NONE


//        val regBackBtnImg=findViewById<ImageView>(R.id.regBackBtnImg)
//        val regLoginNow=findViewById<TextView>(R.id.regLoginNow)
//        val emailParent=findViewById<TextInputLayout>(R.id.emailParent)
//        val passwordParent=findViewById<TextInputLayout>(R.id.passwordParent)
//        val confirmPasswordParent=findViewById<TextInputLayout>(R.id.confirmPasswordParent)

//        emailParent.boxBackgroundMode=TextInputLayout.BOX_BACKGROUND_NONE
//        passwordParent.boxBackgroundMode=TextInputLayout.BOX_BACKGROUND_NONE
//        confirmPasswordParent.boxBackgroundMode=TextInputLayout.BOX_BACKGROUND_NONE
//



//
//
//

//        val regEmail=findViewById<EditText>(R.id.regEmail)
//        val regPassword=findViewById<EditText>(R.id.regPassword)
//        val regConfirmPassword=findViewById<EditText>(R.id.regConfirmPassword)
//        val registerBtn=findViewById<Button>(R.id.registerBtn)

//        registerBtn.setOnClickListener {
//
//            if(regEmail.text.trim().toString().isEmpty() && regPassword.text.trim().toString().isEmpty()
//                && regConfirmPassword.text.trim().toString().isEmpty())
//            {
//                regEmail.error="Please Enter Email"
//                regPassword.error="Please Enter Password"
//                regConfirmPassword.error="Please Enter Confirm Password"
//
//                return@setOnClickListener
//            }
//
//            else if(regPassword.text.trim().toString().isEmpty() && regConfirmPassword.text.trim().toString().isEmpty())
//            {
//                regPassword.error="Please Enter Password"
//                regConfirmPassword.error="Please Enter Confirm Password"
//                return@setOnClickListener
//            }
//
//            else if(regEmail.text.trim().toString().isEmpty())
//            {
//                regEmail.error="Please Enter Email"
//                return@setOnClickListener
//            }

//            else if(regPassword.text.trim().toString().isEmpty())
//            {
//                regPassword.error="Please Enter Password"
//                return@setOnClickListener
//            }
//
//            else if(regConfirmPassword.text.trim().toString().isEmpty())
//            {
//                regConfirmPassword.error="Please Enter Confirm Password"
//                return@setOnClickListener
//            }

//            else if(regPassword.length()<8)
//            {
//                regPassword.error="Minimium 8 Characters Required"
//                return@setOnClickListener
//            }
//
//            else if(regConfirmPassword.length()<8)
//            {
//                regConfirmPassword.error="Minimium 8 Characters Required"
//                return@setOnClickListener
//            }



//            else if(regPassword.text.contentEquals(regConfirmPassword.text))
//            {
//                val intent=Intent(this,HomeActivity::class.java)
//                startActivity(intent)
//            }







        //}


//    }






}