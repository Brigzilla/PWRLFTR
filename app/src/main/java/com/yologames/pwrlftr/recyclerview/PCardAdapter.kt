package com.yologames.pwrlftr.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.databinding.ProgramCardBinding

class PCardAdapter(private val PCards: List<PCard>):RecyclerView.Adapter<PCardViewHolder>() {

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProgramCardBinding.inflate(from, parent, false)
        return PCardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PCardViewHolder, position: Int) {

        holder.bindCards(PCardList[position])

        //val pCard = PCardList[position]
    }

    override fun getItemCount(): Int = PCards.size

//    class OnClickListener(val clickListener: (dCard: PCard) -> Unit) {
//        fun onClick(dCard: PCard) {
//            clickListener(dCard)
//        }
//    }

}