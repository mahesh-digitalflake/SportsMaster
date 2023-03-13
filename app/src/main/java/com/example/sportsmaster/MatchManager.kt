package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MatchManager : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<MatchManagerData>
    lateinit var mgMatchTextId: Array<String>
    lateinit var mgmatchDayId: Array<String>
    lateinit var mgMatchTimeId: Array<String>
    lateinit var mgRightImgId: Array<Int>
    lateinit var mgPencilImgId: Array<Int>
    lateinit var mgWrongImgId: Array<Int>
    lateinit var mgEngVsGermanyTxtId: Array<String>

    private var adapter: MatchManagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_manager)

        val matchManagerBackBtn=findViewById<ImageView>(R.id.matchManagerBackBtn)
        matchManagerBackBtn.setOnClickListener {
            val intent=Intent(this,CreatePlayer::class.java)
            startActivity(intent)
        }

        mgMatchTextId = arrayOf(
            "ENG T20 MATCH 2022", "ENG T20 MATCH 2022", "ENG T20 MATCH 2022",
            "ENG T20 MATCH 2022", "ENG T20 MATCH 2022"
        )

        mgmatchDayId = arrayOf(
            "1d:21m", "1d:21m", "1d:21m", "1d:21m", "1d:21m"
        )

        mgMatchTimeId = arrayOf(
            "July 24, 5:00 PM",
            "July 24, 5:00 PM",
            "July 24, 5:00 PM",
            "July 24, 5:00 PM",
            "July 24, 5:00 PM"
        )

        mgRightImgId = arrayOf(
            R.id.rightImg, R.id.rightImg, R.id.rightImg, R.id.rightImg, R.id.rightImg,
        )

        mgPencilImgId = arrayOf(
            R.id.pencilImg, R.id.pencilImg, R.id.pencilImg, R.id.pencilImg, R.id.pencilImg
        )

        mgWrongImgId = arrayOf(
            R.id.wrongImg, R.id.wrongImg, R.id.wrongImg, R.id.wrongImg, R.id.wrongImg
        )

        mgEngVsGermanyTxtId = arrayOf(
            "England vs Germany",
            "England vs Germany",
            "England vs Germany",
            "England vs Germany",
            "England vs Germany"
        )

        newRecyclerView = findViewById(R.id.matchManagerRv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<MatchManagerData>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in mgRightImgId.indices) {
            val matchMgr = MatchManagerData(
                mgMatchTextId[i], mgmatchDayId[i], mgMatchTimeId[i], mgRightImgId[i],
                mgPencilImgId[i], mgWrongImgId[i], mgEngVsGermanyTxtId[i]
            )

            newArrayList.add(matchMgr)

        }
        // newRecyclerView.adapter=MatchManagerAdapter(applicationContext,newArrayList)

        //To select one recycler view,Below code is for that purpose
        newRecyclerView.adapter = MatchManagerAdapter(
            applicationContext,
            newArrayList,
            object : MatchManagerAdapter.OnClickAction {
                override fun onClickManagerData(matchManagerdata: MatchManagerData) {
                    val intent = Intent(this@MatchManager, PlayerManager::class.java)
                    startActivity(intent)
                }
            })
    }
}