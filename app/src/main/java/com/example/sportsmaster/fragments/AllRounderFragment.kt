package com.example.sportsmaster.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportsmaster.*
import com.example.sportsmaster.databinding.FragmentAllRounderBinding
import com.example.sportsmaster.databinding.FragmentBatBinding



class AllRounderFragment : Fragment() {
    private lateinit var binding : FragmentAllRounderBinding
    private var newArrayList: ArrayList<Players> = ArrayList()
    private var adapter : PlayerAdapter? = null

    lateinit var playerImageId:Array<Int>
    lateinit var playerNameId:Array<String>
    lateinit var playerTeamImgId:Array<Int>
    lateinit var playerTeamNameId:Array<String>
    lateinit var playerPointsId:Array<String>
    lateinit var playerCreditId:Array<Double>
    lateinit var playerPlusImg:Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAllRounderBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root

    }

    private fun initRecyclerView() {
        playerImageId= arrayOf(R.drawable.playericon, R.drawable.playericon,R.drawable.playericon)

        playerNameId= arrayOf("Dawid Malan", "Adil Rashid","Phil Salt")

        playerTeamImgId= arrayOf(R.id.manchesterImg, R.id.manchesterImg,R.id.manchesterImg)

        playerTeamNameId= arrayOf("ENG", "ENG","ENG")

        playerPointsId= arrayOf("73 pts", "73 pts","73 pts")

        playerCreditId= arrayOf(9.5, 9.5,9.5)

        playerPlusImg= arrayOf(R.id.plusIcon, R.id.plusIcon,R.id.plusIcon)

        binding.allRounderRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.allRounderRecyclerView.adapter = adapter
        binding.allRounderRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Players>()
        getUserdata()

    }
    private fun getUserdata() {
        for(i in playerImageId.indices)
        {
            val myPlayer= Players(playerImageId[i],playerNameId[i],playerTeamImgId[i],
                playerTeamNameId[i],playerPointsId[i],playerCreditId[i],playerPlusImg[i])

            newArrayList.add(myPlayer)

//            binding.allRounderRecyclerView.adapter= PlayerAdapter(requireContext(),newArrayList)

            binding.allRounderRecyclerView.adapter=PlayerAdapter(requireContext(),newArrayList, object : PlayerAdapter.OnClickAction {
                override fun onClickCard(players: Players) {
                    val intent= Intent(requireContext(), StarPlayer::class.java)
                    startActivity(intent)
                }

            })
        }
    }
}