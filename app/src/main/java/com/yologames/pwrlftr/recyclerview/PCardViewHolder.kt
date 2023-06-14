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
        cardCellBinding.aspect0.text = pCard.aspect0.toString()
        cardCellBinding.aspect1.text = pCard.aspect1.toString()
        cardCellBinding.aspect2.text = pCard.aspect2.toString()
        cardCellBinding.aspect3.text = pCard.aspect3.toString()
        cardCellBinding.aspect4.text = pCard.aspect4.toString()
        cardCellBinding.aspect5.text = pCard.aspect5.toString()
        cardCellBinding.aspect6.text = pCard.aspect6.toString()
        cardCellBinding.aspect7.text = pCard.aspect7.toString()
        cardCellBinding.aspect8.text = pCard.aspect8.toString()
        cardCellBinding.aspect9.text = pCard.aspect9.toString()

//        cardCellBinding.cardView.setOnClickListener {
//            // D_MOD_SELECTED = dCard.moduleID
//        }
        }

    }