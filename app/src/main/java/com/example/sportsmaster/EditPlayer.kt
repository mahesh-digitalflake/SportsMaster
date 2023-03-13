package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class EditPlayer : AppCompatActivity() {

    val match = arrayOf("Select Match", "IND vs AUS", "ENG vs WI", "NZ vs PAK")
    var selectedMatch = ""

    val team = arrayOf("Select Team", "IND", "ENG", "NZ", "WI", "PAK")
    var selectedTeam = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_player)

        val editPlayerSpinner1 = findViewById<Spinner>(R.id.editPlayerSpinner1)
        val editPlayerSpinner2 = findViewById<Spinner>(R.id.editPlayerSpinner2)

        val arrayAdapter =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, match)
        editPlayerSpinner1.adapter = arrayAdapter
        editPlayerSpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedMatch = match[p2]
                //Toast.makeText(applicationContext,"Selected Gender ="+gender[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val arrayAdapter1 =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, team)
        editPlayerSpinner2.adapter = arrayAdapter1
        editPlayerSpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedTeam = team[p2]
                //Toast.makeText(applicationContext,"Selected Gender ="+gender[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val editPlayerBackBtn=findViewById<ImageView>(R.id.editPlayerBackBtn)
        editPlayerBackBtn.setOnClickListener {
            val intent= Intent(this,PlayerManager::class.java)
            startActivity(intent)
        }
    }
}