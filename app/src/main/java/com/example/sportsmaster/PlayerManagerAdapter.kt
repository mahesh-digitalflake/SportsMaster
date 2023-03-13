package com.example.sportsmaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PlayerManagerAdapter (
    val context: Context,
    private val playerManagers: ArrayList<PlayerManagerData>,
    var onClickAction : OnClickAction): RecyclerView.Adapter<PlayerManagerAdapter.playerManagerVH>()
{
    interface OnClickAction {
        fun onClickPlayerManagerData(playerManagerData: PlayerManagerData)
    }

    class playerManagerVH(v: View):RecyclerView.ViewHolder(v)
    {
        private var mgPlayerNamePm: TextView =v.findViewById(R.id.pmPlayerName)
        private var mgPlayerManagerLine: ImageView =v.findViewById(R.id.playerManagerLine)
        private var mgEnglandTxtPm: TextView =v.findViewById(R.id.pmEnglandTxt)
        private var mgPencilImgPlayerMgr: ImageView =v.findViewById(R.id.pencilImgPlayerMgr)
        private var mgWrongImgPlayerMgr: ImageView =v.findViewById(R.id.wrongImgPlayerMgr)

        fun bind(
            context: Context,
            selectedPlayerManagers: PlayerManagerData,
            onClickAction: PlayerManagerAdapter.OnClickAction
        )
        {
            mgPlayerNamePm.text=selectedPlayerManagers.pmPlayerNameTxt
            Glide
                .with(context)
                .load(R.drawable.player_manager_line)
                .centerInside()
                .into(mgPlayerManagerLine)

            mgEnglandTxtPm.text=selectedPlayerManagers.pmEnglandTxt

            Glide
                .with(context)
                .load(R.drawable.pencil)
                .centerInside()
                .into(mgPencilImgPlayerMgr)

            Glide
                .with(context)
                .load(R.drawable.wrong)
                .centerInside()
                .into(mgWrongImgPlayerMgr)

            itemView.setOnClickListener {
                onClickAction.onClickPlayerManagerData(selectedPlayerManagers)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): playerManagerVH {
        val playerManagerItemView= LayoutInflater.from(context).inflate(R.layout.player_manager_list,parent,
            false)
        return playerManagerVH(playerManagerItemView)
    }

    override fun onBindViewHolder(holder: playerManagerVH, position: Int) {
        val playerManagerItem=playerManagers[position]
        holder.bind(context,playerManagerItem,onClickAction)
    }

    override fun getItemCount(): Int {
        return playerManagers.size
    }
}