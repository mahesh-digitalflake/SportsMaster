package com.example.sportsmaster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    val context :Context,
    private val cricketList:ArrayList<Cricket>,
    var onClickAction : OnClickAction):RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    interface OnClickAction {
        fun onClickCard(cricket: Cricket)
    }
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
    {
        val matchTitle:TextView=itemView.findViewById(R.id.matchTitle)
        val englandLogo:ImageView=itemView.findViewById(R.id.englandLogo)
        val englandText:TextView=itemView.findViewById(R.id.englandText)
        val day:TextView=itemView.findViewById(R.id.day)
        val time:TextView=itemView.findViewById(R.id.time)
        val germanyLogo:ImageView=itemView.findViewById(R.id.germanyLogo)
        val germanyText:TextView=itemView.findViewById(R.id.germanyText)

        fun bind(context:Context,cricket: Cricket,onClickAction: OnClickAction) {
            matchTitle.text = cricket.title
            englandLogo.setImageResource(cricket.engImg)
            englandText.text=cricket.engTxt
            day.text=cricket.dayTxt
            time.text=cricket.timeTxt
            germanyLogo.setImageResource(cricket.gerImg)
            germanyText.text=cricket.gerTxt

            itemView.setOnClickListener {
                onClickAction.onClickCard(cricket)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView=LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=cricketList[position]
        holder.bind(context,currentItem, onClickAction)
    }

    override fun getItemCount(): Int {
       return cricketList.size
    }


}