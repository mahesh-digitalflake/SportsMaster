package com.example.sportsmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.sportsmaster.databinding.FragmentBatBinding
import com.example.sportsmaster.fragments.AllRounderFragment
import com.example.sportsmaster.fragments.BatFragment
import com.example.sportsmaster.fragments.BowlFragment
import com.example.sportsmaster.fragments.WicketKeeperFragment
import com.example.sportsmaster.fragments.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class Select_Players : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_players)

        setUpTabs()

        val selectPlayerBackBtn=findViewById<ImageView>(R.id.selectPlayerBackBtn)
        val selectStarPlayerBtn=findViewById<Button>(R.id.selectStarPlayerBtn)

        selectStarPlayerBtn.setOnClickListener {
            val intent=Intent(this,StarPlayer::class.java)
            startActivity(intent)
        }

        selectPlayerBackBtn.setOnClickListener {
            val intent=Intent(this,Create_Team::class.java)
            startActivity(intent)

        }
    }



    private fun setUpTabs()
    {
        val viewPager=findViewById<ViewPager>(R.id.viewPager)
       val tabs =findViewById<TabLayout>(R.id.tabs)

        val adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(WicketKeeperFragment(),"WK")
        adapter.addFragment(BatFragment(),"BAT")
        adapter.addFragment(AllRounderFragment(),"AllR")
        adapter.addFragment(BowlFragment(),"BOWL")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.heart)
        tabs.getTabAt(1)!!.setIcon(R.drawable.heart)
        tabs.getTabAt(2)!!.setIcon(R.drawable.heart)
        tabs.getTabAt(3)!!.setIcon(R.drawable.heart)
    }
}