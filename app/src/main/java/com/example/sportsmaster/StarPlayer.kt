package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StarPlayer : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<StarPlayersData>
    lateinit var starPlayerImgId:Array<Int>
    lateinit var starPlayerCountryId:Array<String>
    lateinit var starPlayerBowlId:Array<String>
    lateinit var starPlayerNameId:Array<String>
    lateinit var starPlayerCaptainId:Array<Int>
    lateinit var starPlayerViceCaptainId:Array<Int>
    lateinit var starPlayerPointsId:Array<String>
    lateinit var starPlayerCreditsId:Array<Double>
    lateinit var starImageId:Array<Int>

    private var adapter:StarPlayerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_player)

        val selectStarPlayerBackBtn=findViewById<ImageView>(R.id.selectStarPlayerBackBtn)
        selectStarPlayerBackBtn.setOnClickListener {
            val intent=Intent(this,Select_Players::class.java)
            startActivity(intent)
        }

        val viewTeamBtn=findViewById<Button>(R.id.viewTeamBtn)
        viewTeamBtn.setOnClickListener {
            val intent=Intent(this,CreateMatch::class.java)
            startActivity(intent)
        }

        starPlayerImgId= arrayOf(
            R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,
            R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,R.id.starPlayerIcon,
            R.id.starPlayerIcon
        )

        starPlayerCountryId= arrayOf(
            "ENG","ENG","ENG","ENG","ENG",
            "ENG","ENG","ENG","ENG","ENG",
            "ENG"
        )
        starPlayerBowlId= arrayOf(
            "BWL","BWL","BWL","BWL","BWL",
            "BWL","BWL","BWL","BWL","BWL",
            "BWL"
        )

        starPlayerNameId= arrayOf(
            "Jos Buttler","Jonny Bairstow","Harry Brook","Sam Curran","Alex Hales",
            "Chris Jordan","Liam Livingstone","Dawid Malan","Adil Rashid","Phil Salt",
            "Moeen Ali"
        )

        starPlayerCaptainId= arrayOf(
            R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,
            R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,R.id.starPlayerCpt,
            R.id.starPlayerCpt
        )

        starPlayerViceCaptainId= arrayOf(
            R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,
            R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,R.id.starPlayerVcpt,
            R.id.starPlayerVcpt
        )

        starPlayerPointsId= arrayOf(
            "73 pts","73 pts","73 pts","73 pts","73 pts",
            "73 pts","73 pts","73 pts","73 pts","73 pts",
            "73 pts"
        )

        starPlayerCreditsId= arrayOf(
            9.5,9.5,9.5,9.5,9.5,
            9.5,9.5,9.5,9.5,9.5,
            9.5
        )

        starImageId= arrayOf(
            R.id.starImg,R.id.starImg,R.id.starImg,R.id.starImg,R.id.starImg,
            R.id.starImg,R.id.starImg,R.id.starImg,R.id.starImg,R.id.starImg,
            R.id.starImg
        )

        newRecyclerView=findViewById(R.id.starPlayerRv)
        newRecyclerView.layoutManager= LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<StarPlayersData>()
        getUserdata()


    }

    private fun getUserdata() {
        for(i in starPlayerImgId.indices)
        {
            val star1=StarPlayersData(starPlayerImgId[i],starPlayerCountryId[i],starPlayerBowlId[i],
            starPlayerNameId[i],starPlayerCaptainId[i],starPlayerViceCaptainId[i],starPlayerPointsId[i],
            starPlayerCreditsId[i],starImageId[i])

            newArrayList.add(star1)

        }
        newRecyclerView.adapter=StarPlayerAdapter(applicationContext,newArrayList)
    }
}