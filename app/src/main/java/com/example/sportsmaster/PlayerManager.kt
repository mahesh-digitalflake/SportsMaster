package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayerManager : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<PlayerManagerData>
    lateinit var pmPlayerNameId: Array<String>
    lateinit var playerManagerLineId: Array<Int>
    lateinit var pmEnglandTxtId: Array<String>
    lateinit var pencilImgPlayerMgrId: Array<Int>
    lateinit var wrongImgPlayerMgrId: Array<Int>

    private var adapter: MatchManagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_manager)

        val playerManagerBackBtn=findViewById<ImageView>(R.id.playerManagerBackBtn)
        playerManagerBackBtn.setOnClickListener {
            val intent=Intent(this,MatchManager::class.java)
            startActivity(intent)
        }

        pmPlayerNameId = arrayOf(
            "Alakh Pandey","Alakh Pandey","Alakh Pandey","Alakh Pandey","Alakh Pandey","Alakh Pandey"
        )

        playerManagerLineId= arrayOf(
            R.id.playerManagerLine,R.id.playerManagerLine,R.id.playerManagerLine,R.id.playerManagerLine,
            R.id.playerManagerLine,R.id.playerManagerLine
        )

        pmEnglandTxtId= arrayOf(
            "England","England","England","England","England","England"
        )

        pencilImgPlayerMgrId= arrayOf(
            R.id.pencilImg,R.id.pencilImg,R.id.pencilImg,R.id.pencilImg,R.id.pencilImg,R.id.pencilImg,
        )

        wrongImgPlayerMgrId= arrayOf(
            R.id.wrongImg,R.id.wrongImg,R.id.wrongImg,R.id.wrongImg,R.id.wrongImg,R.id.wrongImg
        )

        newRecyclerView = findViewById(R.id.playerManagerRv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<PlayerManagerData>()
        getUserdata()


    }

    private fun getUserdata() {
        for (i in playerManagerLineId.indices) {
            val playerMgr = PlayerManagerData(
                pmPlayerNameId[i],playerManagerLineId[i], pmEnglandTxtId[i], pencilImgPlayerMgrId[i],
                wrongImgPlayerMgrId[i]
            )

            newArrayList.add(playerMgr)

            newRecyclerView.adapter = PlayerManagerAdapter(
                applicationContext,
                newArrayList,
                object : PlayerManagerAdapter.OnClickAction {
                    override fun onClickPlayerManagerData(playerManagerData: PlayerManagerData) {
                        val intent=Intent(this@PlayerManager,EditPlayer::class.java)
                        startActivity(intent)
                    }

                })

        }
    }
}