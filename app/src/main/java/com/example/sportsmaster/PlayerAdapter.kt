package com.example.sportsmaster

import android.content.Context
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class PlayerAdapter(
    val context: Context,
    private val playerList:ArrayList<Players>,
    var onClickAction: OnClickAction
    ) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {


    interface OnClickAction {
        fun onClickCard(players: Players)
//        fun onClickAdd(players: Players)
    }

    class PlayerViewHolder(playerItemView:View):RecyclerView.ViewHolder(playerItemView)
    {
        val playerIcon:ImageView=playerItemView.findViewById(R.id.playerIcon)
        val playerName:TextView=playerItemView.findViewById(R.id.playerName)
        val playerTeamIcon:ImageView=playerItemView.findViewById(R.id.playerTeamIcon)
        val playerTeamName:TextView=playerItemView.findViewById(R.id.playerTeamName)
        val points:TextView=playerItemView.findViewById(R.id.points)
        val credits:TextView=playerItemView.findViewById(R.id.credits)
        val plusIcon:ImageView=playerItemView.findViewById(R.id.plusIcon)

        fun bind(context: Context, players: Players,onClickAction:OnClickAction) {

            Glide
                .with(context)
                .load(R.drawable.playericon)
                .centerInside()
                .into(playerIcon)

            playerName.text=players.playerName

            Glide
                .with(context)
                .load(R.drawable.manchester_logo)
                .centerInside()
                .into(playerTeamIcon)

            playerTeamName.text=players.playerTeamName
            points.text=players.playerPoints
            credits.text= players.playerCredits.toString()

            Glide
                .with(context)
                .load(R.drawable.plusicon)
                .centerInside()
                .into(plusIcon)

//            plusIcon.setOnClickListener {
//                onClickAction.onClickAdd(players)
//            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val playerItemView=LayoutInflater.from(context).inflate(R.layout.player_list,parent,
            false)
        return PlayerViewHolder(playerItemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val currentPlayerItem=playerList[position]
        holder.bind(context,currentPlayerItem,onClickAction)
        holder.itemView.setOnClickListener {
            onClickAction.onClickCard(currentPlayerItem)
        }

    }

    override fun getItemCount(): Int {
        return playerList.size
    }


}