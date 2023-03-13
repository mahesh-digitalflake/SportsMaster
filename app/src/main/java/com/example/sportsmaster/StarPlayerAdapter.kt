package com.example.sportsmaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StarPlayerAdapter(val context:Context,
private val starPlayers:ArrayList<StarPlayersData>):RecyclerView.Adapter<StarPlayerAdapter.starPlayerVH>() {
    class starPlayerVH(v: View):RecyclerView.ViewHolder(v)
    {
        private var starPlayerIcon:ImageView=v.findViewById(R.id.starPlayerIcon)
        private var starPlayerCntry:TextView=v.findViewById(R.id.starPlayerCntry)
        private var starPlayerBwl:TextView=v.findViewById(R.id.starPlayerBwl)
        private var starPlayerNm:TextView=v.findViewById(R.id.starPlayerNm)
        private var starPlayerCpt:ImageView=v.findViewById(R.id.starPlayerCpt)
        private var starPlayerVcpt:ImageView=v.findViewById(R.id.starPlayerVcpt)
        private var starPlayerPoints:TextView=v.findViewById(R.id.starPlayerPts)
        private var starPlayerCredits:TextView=v.findViewById(R.id.starPlayerCrd)
        private var starImg:ImageView=v.findViewById(R.id.starImg)

        fun bind(context: Context,selectedStarPlayers: StarPlayersData){
            Glide
                .with(context)
                .load(R.drawable.playericon)
                .centerInside()
                .into(starPlayerIcon)

            starPlayerCntry.text=selectedStarPlayers.starPlayerCountry
            starPlayerBwl.text=selectedStarPlayers.starPlayerBowl
            starPlayerNm.text=selectedStarPlayers.starPlayerName

            Glide
                .with(context)
                .load(R.drawable.captain)
                .centerInside()
                .into(starPlayerCpt)

            Glide
                .with(context)
                .load(R.drawable.vice_captain)
                .centerInside()
                .into(starPlayerVcpt)

            starPlayerPoints.text=selectedStarPlayers.starPlayerPoints
            starPlayerCredits.text= selectedStarPlayers.starPlayerCredits.toString()

            Glide
                .with(context)
                .load(R.drawable.star)
                .centerInside()
                .into(starImg)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): starPlayerVH {
        val starPlayerItemView= LayoutInflater.from(context).inflate(R.layout.star_player_list,parent,
            false)
        return starPlayerVH(starPlayerItemView)
    }

    override fun onBindViewHolder(holder: starPlayerVH, position: Int) {
        val starPlayerItem=starPlayers[position]
        holder.bind(context,starPlayerItem)
    }

    override fun getItemCount(): Int {
        return starPlayers.size
    }

}