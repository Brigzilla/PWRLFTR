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
        val reviewingSession = pCard.reviewingSession

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

        cardCellBinding.reviewButton.setOnClickListener{
            pCard.reviewingSession =! reviewingSession
            bindCards(pCard)
        }

        cardCellBinding.commitReview.setOnClickListener{
            pCard.reviewingSession = false
            cardCellBinding.commitReview.visibility = View.INVISIBLE
            bindCards(pCard)
        }

        if (reviewingSession) {
            cardCellBinding.difficulty.visibility = View.VISIBLE
            cardCellBinding.commitReview.visibility = View.VISIBLE
            cardCellBinding.reviewButton.visibility = View.GONE
        }
        if (!reviewingSession) cardCellBinding.difficulty.visibility = View.GONE


        if (pCard.aspect0 != "_" ) {
            cardCellBinding.aspect0.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect0Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect0Seekbar.visibility = View.GONE
        }
        if (pCard.aspect0 == "_" ) {
            cardCellBinding.aspect0.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect0Seekbar.visibility = View.GONE
        }
        if (pCard.aspect1 != "_" ) {
            cardCellBinding.aspect1.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect1Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect1Seekbar.visibility = View.GONE
        }
        if (pCard.aspect1 == "_" ) {
            cardCellBinding.aspect1.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect1Seekbar.visibility = View.GONE
        }
        if (pCard.aspect2 != "_" ) {
            cardCellBinding.aspect2.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect2Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect2Seekbar.visibility = View.GONE
        }
        if (pCard.aspect2 == "_" ) {
            cardCellBinding.aspect2.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect2Seekbar.visibility = View.GONE
        }
        if (pCard.aspect3 != "_" ) {
            cardCellBinding.aspect3.visibility = View.VISIBLE
            if (reviewingSession) cardCellBinding.aspect3Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect3Seekbar.visibility = View.GONE
        }
        if (pCard.aspect3 == "_" ) {
            cardCellBinding.aspect3.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect3Seekbar.visibility = View.GONE
        }
        if (pCard.aspect4 != "_" ) {
            cardCellBinding.aspect4.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect4Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect4Seekbar.visibility = View.GONE
        }
        if (pCard.aspect4 == "_" ) {
            cardCellBinding.aspect4.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect4Seekbar.visibility = View.GONE
        }
        if (pCard.aspect5 != "_" ) {
            cardCellBinding.aspect5.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect5Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect5Seekbar.visibility = View.GONE
        }
        if (pCard.aspect5 == "_" ) {
            cardCellBinding.aspect5.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect5Seekbar.visibility = View.GONE
        }
        if (pCard.aspect6 != "_" ) {
            cardCellBinding.aspect6.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect6Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect6Seekbar.visibility = View.GONE
        }
        if (pCard.aspect6 == "_" ) {
            cardCellBinding.aspect6.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect6Seekbar.visibility = View.GONE
        }
        if (pCard.aspect7 != "_" ) {
            cardCellBinding.aspect7.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect7Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect7Seekbar.visibility = View.GONE
        }
        if (pCard.aspect7 == "_" ) {
            cardCellBinding.aspect7.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect7Seekbar.visibility = View.GONE
        }
        if (pCard.aspect8 != "_" ) {
            cardCellBinding.aspect8.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect8Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect8Seekbar.visibility = View.GONE
        }
        if (pCard.aspect8 == "_" ) {
            cardCellBinding.aspect8.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect8Seekbar.visibility = View.GONE
        }
        if (pCard.aspect9 != "_" ) {
            cardCellBinding.aspect9.visibility = View.VISIBLE
            if (reviewingSession)cardCellBinding.aspect9Seekbar.visibility = View.VISIBLE
            if (!reviewingSession)cardCellBinding.aspect9Seekbar.visibility = View.GONE
        }
        if (pCard.aspect9 == "_" ) {
            cardCellBinding.aspect9.visibility = View.GONE
            if (!reviewingSession)cardCellBinding.aspect9Seekbar.visibility = View.GONE
        }

//        cardCellBinding.cardView.setOnClickListener {
//            // D_MOD_SELECTED = dCard.moduleID
//        }
    }

}