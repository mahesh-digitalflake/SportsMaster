package com.example.sportsmaster.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportsmaster.*
import com.example.sportsmaster.databinding.FragmentWicketKeeperBinding

class WicketKeeperFragment : Fragment() {
    private lateinit var binding : FragmentWicketKeeperBinding
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
        binding = FragmentWicketKeeperBinding.inflate(inflater, container, false)
        initRecyclerView()

        return binding.root

    }

    private fun initRecyclerView() {
        playerImageId= arrayOf(R.drawable.playericon, R.drawable.playericon)

        playerNameId= arrayOf("Jos Buttler", "Jonny Bairstow")

        playerTeamImgId= arrayOf(R.id.manchesterImg, R.id.manchesterImg)

        playerTeamNameId= arrayOf("ENG", "ENG")

        playerPointsId= arrayOf("75 pts", "73 pts")

        playerCreditId= arrayOf(9.5, 9.5)

        playerPlusImg= arrayOf(R.id.plusIcon, R.id.plusIcon)

        binding.wicketKeepersRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.wicketKeepersRecyclerView.adapter = adapter
        binding.wicketKeepersRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Players>()
        getUserdata()

    }
    private fun getUserdata() {
        for(i in playerImageId.indices)
        {
            val myPlayer=Players(playerImageId[i],playerNameId[i],playerTeamImgId[i],
                playerTeamNameId[i],playerPointsId[i],playerCreditId[i],playerPlusImg[i])

            newArrayList.add(myPlayer)

//            binding.wicketKeepersRecyclerView.adapter=PlayerAdapter(requireContext(),newArrayList)


            binding.wicketKeepersRecyclerView.adapter=PlayerAdapter(requireContext(),newArrayList, object : PlayerAdapter.OnClickAction {
                override fun onClickCard(players: Players) {
                    val intent= Intent(requireContext(),StarPlayer::class.java)
                    startActivity(intent)
                }

//                override fun onClickAdd(players: Players) {
//                    val intent= Intent(requireContext(),Create_Team::class.java)
//                    startActivity(intent)
//                }

            })
        }
    }
}