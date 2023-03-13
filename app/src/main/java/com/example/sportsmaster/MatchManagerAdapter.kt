package com.example.sportsmaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MatchManagerAdapter(
    val context: Context,
    private val matchManagers: ArrayList<MatchManagerData>,
    var onClickAction : OnClickAction
): RecyclerView.Adapter<MatchManagerAdapter.matchManagerVH>()
{
    interface OnClickAction {
        fun onClickManagerData(matchManagerdata: MatchManagerData)
    }
    class matchManagerVH(v: View):RecyclerView.ViewHolder(v)
    {
        private var mgMatchText: TextView =v.findViewById(R.id.t20MatchTxt)
        private var mgMatchDay: TextView =v.findViewById(R.id.matchDay)
        private var mgMatchTime: TextView =v.findViewById(R.id.matchTime)
        private var mgRightImg: ImageView =v.findViewById(R.id.rightImg)
        private var mgPencilImg: ImageView =v.findViewById(R.id.pencilImg)
        private var mgWrongImg: ImageView =v.findViewById(R.id.wrongImg)
        private var mgEngVsGermanyTxt: TextView =v.findViewById(R.id.engVsGermanyTxt)


        fun bind(
            context: Context,
            selectedMatchManagers: MatchManagerData,
            onClickAction:OnClickAction)
        {
            mgMatchText.text=selectedMatchManagers.t20MatchTxt
            mgMatchDay.text=selectedMatchManagers.matchDay
            mgMatchTime.text=selectedMatchManagers.matchTime

            Glide
                .with(context)
                .load(R.drawable.right_img)
                .centerInside()
                .into(mgRightImg)

            Glide
                .with(context)
                .load(R.drawable.pencil)
                .centerInside()
                .into(mgPencilImg)

            Glide
                .with(context)
                .load(R.drawable.wrong)
                .centerInside()
                .into(mgWrongImg)

            mgEngVsGermanyTxt.text=selectedMatchManagers.engVsGermanyTxt

            itemView.setOnClickListener {
                onClickAction.onClickManagerData(selectedMatchManagers)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): matchManagerVH {
        val matchManagerItemView= LayoutInflater.from(context).inflate(R.layout.match_manager_list,parent,
            false)
        return matchManagerVH(matchManagerItemView)
    }

    override fun onBindViewHolder(holder: matchManagerVH, position: Int) {
        val matchManagerItem=matchManagers[position]
        holder.bind(context,matchManagerItem,onClickAction)

//        holder.itemView.setOnClickListener {
//            onClickAction.onClickManagerData(matchManagerItem)
//        }
    }

    override fun getItemCount(): Int {
        return matchManagers.size
    }
}