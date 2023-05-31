package com.yologames.pwrlftr.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.databinding.ProgramCardBinding

class PCardViewHolder(
    private val cardCellBinding: ProgramCardBinding,
):RecyclerView.ViewHolder(cardCellBinding.root) {

    fun bindCards(pCard: PCard)
    {
        cardCellBinding.title.text = pCard.title
        cardCellBinding.exercise.text = pCard.exercise
        cardCellBinding.sets.text = pCard.sets.toString()
        cardCellBinding.reps.text = pCard.reps.toString()
        cardCellBinding.weight.text = pCard.weight.toString()

//        cardCellBinding.cardView.setOnClickListener {
//            // D_MOD_SELECTED = dCard.moduleID
//        }
        }

    }