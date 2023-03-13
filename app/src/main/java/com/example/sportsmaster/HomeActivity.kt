package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class HomeActivity : AppCompatActivity() {
    private lateinit var newRecyclerView:RecyclerView
    private lateinit var  newArrayList:ArrayList<Cricket>
    lateinit var titleText:Array<String>
    lateinit var engCountryLogoImg:Array<Int>
    lateinit var engCountryTxt:Array<String>
    lateinit var dayText:Array<String>
    lateinit var timeText:Array<String>
    lateinit var gerCountryLogoImg:Array<Int>
    lateinit var gerCountryTxt:Array<String>
    
    private var adapter : MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        titleText= arrayOf(
            "ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022",
            "ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022","ENG T20 MATCH 2022"
        )

        engCountryLogoImg= arrayOf(
            R.drawable.englandflag, R.drawable.englandflag, R.drawable.englandflag,
            R.drawable.englandflag, R.drawable.englandflag,
            R.drawable.englandflag, R.drawable.englandflag, R.drawable.englandflag,
            R.drawable.englandflag, R.drawable.englandflag
        )

        engCountryTxt= arrayOf(
            "England","England","England","England","England",
            "England","England","England","England","England"
        )

        dayText= arrayOf(
            "1d:21m","2d:45m","4d:36m","5d:28m","9d:57m",
            "10d:07m","11d:12m","12d:15m","13d:20m","15d:07m"
        )

        timeText= arrayOf(
            "July 24, 5:00 PM","July 26, 5:00 PM","July 28, 5:00 PM","July 29, 5:00 PM","August 03, 5:00 PM",
            "August 04, 6:00 PM","August 05, 7:00 PM","August 06, 8:00 PM","August 07, 9:00 PM","August 08, 10:00 PM"
        )

        gerCountryLogoImg= arrayOf(
            R.drawable.germanyflag,R.drawable.germanyflag,R.drawable.germanyflag,
            R.drawable.germanyflag,R.drawable.germanyflag,
            R.drawable.germanyflag,R.drawable.germanyflag,R.drawable.germanyflag,
            R.drawable.germanyflag,R.drawable.germanyflag
        )

        gerCountryTxt= arrayOf(
            "Germany","Germany","Germany","Germany","Germany",
            "Germany","Germany","Germany","Germany","Germany",
        )

        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Cricket>()
        getUserdata()

    }

    private fun getUserdata() {
        for(i in titleText.indices)
        {
            val cric1=Cricket(titleText[i],engCountryLogoImg[i],engCountryTxt[i],dayText[i],timeText[i],gerCountryLogoImg[i],gerCountryTxt[i])
            newArrayList.add(cric1)
        }
//        newRecyclerView.adapter=MyAdapter(newArrayList)

        //To select one recycler view,Below code is for that purpose
        newRecyclerView.adapter=MyAdapter(applicationContext,newArrayList, object : MyAdapter.OnClickAction {
            override fun onClickCard(cricket: Cricket) {
                val intent=Intent(this@HomeActivity,Create_Team::class.java)
                startActivity(intent)
        }

        })
    }
}
