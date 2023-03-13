package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner

class CreatePlayer : AppCompatActivity() {
    val match= arrayOf("Select Match","IND vs AUS","ENG vs WI","NZ vs PAK")
    var selectedMatch = ""

    val team= arrayOf("Select Team","IND","ENG","NZ","WI","PAK")
    var selectedTeam = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_player)

        val spinner=findViewById<Spinner>(R.id.spinner)
        val spinner1=findViewById<Spinner>(R.id.spinner1)



        val arrayAdapter=
            ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,match)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedMatch = match[p2]
                //Toast.makeText(applicationContext,"Selected Gender ="+gender[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val arrayAdapter1=
            ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,team)
        spinner1.adapter=arrayAdapter1
        spinner1.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedTeam = team[p2]
                //Toast.makeText(applicationContext,"Selected Gender ="+gender[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val submitLastBtn=findViewById<Button>(R.id.submitLastBtn)
        submitLastBtn.setOnClickListener {
            val intent=Intent(this,MatchManager::class.java)
            startActivity(intent)
        }

        val createPlayerBackBtn=findViewById<ImageView>(R.id.createPlayerBackBtn)
        createPlayerBackBtn.setOnClickListener {
            val intent=Intent(this,CreateMatch::class.java)
            startActivity(intent)
        }
    }
}