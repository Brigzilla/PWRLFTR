package com.yologames.pwrlftr.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr._session_feedback_left
import com.yologames.pwrlftr._sessions_reviewed
import com.yologames.pwrlftr.databinding.ProgramCardBinding

class PCardAdapter(private val PCards: List<PCard>):RecyclerView.Adapter<PCardViewHolder>() {

    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PCardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ProgramCardBinding.inflate(from, parent, false)
        return PCardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PCardViewHolder, position: Int) {
        _session_feedback_left.add(false)
        holder.bindCards(PCardList[position])

        val pCard = PCardList[position]
    }

    override fun getItemCount(): Int = PCards.size

}