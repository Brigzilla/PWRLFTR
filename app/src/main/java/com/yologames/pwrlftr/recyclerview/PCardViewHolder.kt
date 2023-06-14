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

        if (pCard.aspect0 != "_" ) cardCellBinding.aspect0.visibility = View.VISIBLE
        if (pCard.aspect0 == "_" ) cardCellBinding.aspect0.visibility = View.GONE
        if (pCard.aspect1 != "_" ) cardCellBinding.aspect1.visibility = View.VISIBLE
        if (pCard.aspect1 == "_" ) cardCellBinding.aspect1.visibility = View.GONE
        if (pCard.aspect2 != "_" ) cardCellBinding.aspect2.visibility = View.VISIBLE
        if (pCard.aspect2 == "_" ) cardCellBinding.aspect2.visibility = View.GONE
        if (pCard.aspect3 != "_" ) cardCellBinding.aspect3.visibility = View.VISIBLE
        if (pCard.aspect3 == "_" ) cardCellBinding.aspect3.visibility = View.GONE
        if (pCard.aspect4 != "_" ) cardCellBinding.aspect4.visibility = View.VISIBLE
        if (pCard.aspect4 == "_" ) cardCellBinding.aspect4.visibility = View.GONE
        if (pCard.aspect5 != "_" ) cardCellBinding.aspect5.visibility = View.VISIBLE
        if (pCard.aspect5 == "_" ) cardCellBinding.aspect5.visibility = View.GONE
        if (pCard.aspect6 != "_" ) cardCellBinding.aspect6.visibility = View.VISIBLE
        if (pCard.aspect6 == "_" ) cardCellBinding.aspect6.visibility = View.GONE
        if (pCard.aspect7 != "_" ) cardCellBinding.aspect7.visibility = View.VISIBLE
        if (pCard.aspect7 == "_" ) cardCellBinding.aspect7.visibility = View.GONE
        if (pCard.aspect8 != "_" ) cardCellBinding.aspect8.visibility = View.VISIBLE
        if (pCard.aspect8 == "_" ) cardCellBinding.aspect8.visibility = View.GONE
        if (pCard.aspect9 != "_" ) cardCellBinding.aspect9.visibility = View.VISIBLE
        if (pCard.aspect0 == "_" ) cardCellBinding.aspect9.visibility = View.GONE

//        cardCellBinding.cardView.setOnClickListener {
//            // D_MOD_SELECTED = dCard.moduleID
//        }
    }

}