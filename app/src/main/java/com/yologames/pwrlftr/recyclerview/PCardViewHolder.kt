package com.yologames.pwrlftr.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.*
import com.yologames.pwrlftr.databinding.ProgramCardBinding


class PCardViewHolder(
    private val cardCellBinding: ProgramCardBinding,
    private val callback: PCardAdapter.MyCallback
):RecyclerView.ViewHolder(cardCellBinding.root) {

    interface PCardViewHolderListener {
        fun onItemClicked()
    }

    fun bindCards(pCard: PCard)
    {
        val reviewingSession = pCard.reviewingSession
        cardCellBinding.title.text = pCard.title

        if (!pCard.canReview)
        {
            cardCellBinding.reviewButton.visibility = View.INVISIBLE
//            cardCellBinding.reviewButton.text = "Finished"
            cardCellBinding.reviewButton.setIconResource(R.drawable.ic_baseline_check_24)
        }

            if (!_session_feedback_left[adapterPosition]) {
                cardCellBinding.finishedMarker.visibility = View.INVISIBLE
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
                cardCellBinding.reviewButton.visibility = View.VISIBLE
                cardCellBinding.reviewButton.setOnClickListener {
                    if (pCard.canReview) {
                        pCard.reviewingSession = true
                    }
                    if (!pCard.canReview){
                        _sessions_reviewed += 1
                        _session_feedback_left[adapterPosition] = true
                        compressAll()
                    }

                    bindCards(pCard)
                }

                cardCellBinding.commitReview.setOnClickListener {
                    disableSeekBars()
                    cardCellBinding.reviewButton.visibility = View.GONE
                    cardCellBinding.commitReview.visibility = View.INVISIBLE
                    _sessions_reviewed += 1
                    _session_feedback_left[adapterPosition] = true
                    cardCellBinding.finishedMarker.visibility = View.VISIBLE
                    pCard.reviewingSession = false
                    callback.onItemClicked()
                    bindCards(pCard)
                }


                cardCellBinding.minimise.setOnClickListener {
                    cardCellBinding.minimise.visibility = View.GONE
                }


                if (reviewingSession && !_session_feedback_left[adapterPosition]) {
//                    cardCellBinding.difficulty.visibility = View.VISIBLE
                    cardCellBinding.commitReview.visibility = View.VISIBLE
                    cardCellBinding.reviewButton.visibility = View.GONE

                }

//                if (!reviewingSession && !_session_feedback_left[adapterPosition]) cardCellBinding.difficulty.visibility =
//                    View.GONE

                if (_session_feedback_left[adapterPosition]) {

                    compressAll() //don't bind cards it breaks everything
                }

                if (!_session_feedback_left[adapterPosition]) {
                    if (pCard.aspect0 != "_") {
                        cardCellBinding.aspect0.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect0Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect0Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect0 == "_") {
                        cardCellBinding.aspect0.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect0Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect1 != "_") {
                        cardCellBinding.aspect1.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect1Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect1Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect1 == "_") {
                        cardCellBinding.aspect1.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect1Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect2 != "_") {
                        cardCellBinding.aspect2.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect2Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect2Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect2 == "_") {
                        cardCellBinding.aspect2.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect2Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect3 != "_") {
                        cardCellBinding.aspect3.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect3Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect3Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect3 == "_") {
                        cardCellBinding.aspect3.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect3Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect4 != "_") {
                        cardCellBinding.aspect4.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect4Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect4Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect4 == "_") {
                        cardCellBinding.aspect4.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect4Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect5 != "_") {
                        cardCellBinding.aspect5.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect5Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect5Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect5 == "_") {
                        cardCellBinding.aspect5.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect5Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect6 != "_") {
                        cardCellBinding.aspect6.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect6Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect6Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect6 == "_") {
                        cardCellBinding.aspect6.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect6Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect7 != "_") {
                        cardCellBinding.aspect7.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect7Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect7Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect7 == "_") {
                        cardCellBinding.aspect7.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect7Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect8 != "_") {
                        cardCellBinding.aspect8.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect8Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect8Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect8 == "_") {
                        cardCellBinding.aspect8.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect8Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect9 != "_") {
                        cardCellBinding.aspect9.visibility = View.VISIBLE
                        if (reviewingSession) cardCellBinding.aspect9Seekbar.visibility =
                            View.VISIBLE
                        if (!reviewingSession) cardCellBinding.aspect9Seekbar.visibility = View.GONE
                    }
                    if (pCard.aspect9 == "_") {
                        cardCellBinding.aspect9.visibility = View.GONE
                        if (!reviewingSession) cardCellBinding.aspect9Seekbar.visibility = View.GONE

                    }

                }
            } else {
                modifyOffset(pCard.exercise)
                compressAll()
            }



    }

    init {
        cardCellBinding.commitReview.setOnClickListener {
            callback?.onItemClicked()
        }
    }


    private fun compressAll()
    {

        cardCellBinding.aspect0.visibility = View.GONE
        cardCellBinding.aspect0Seekbar.visibility = View.GONE
        cardCellBinding.aspect1.visibility = View.GONE
        cardCellBinding.aspect1Seekbar.visibility = View.GONE
        cardCellBinding.aspect2.visibility = View.GONE
        cardCellBinding.aspect2Seekbar.visibility = View.GONE
        cardCellBinding.aspect3.visibility = View.GONE
        cardCellBinding.aspect3Seekbar.visibility = View.GONE
        cardCellBinding.aspect4.visibility = View.GONE
        cardCellBinding.aspect4Seekbar.visibility = View.GONE
        cardCellBinding.aspect5.visibility = View.GONE
        cardCellBinding.aspect5Seekbar.visibility = View.GONE
        cardCellBinding.aspect6.visibility = View.GONE
        cardCellBinding.aspect6Seekbar.visibility = View.GONE
        cardCellBinding.aspect7.visibility = View.GONE
        cardCellBinding.aspect7Seekbar.visibility = View.GONE
        cardCellBinding.aspect8.visibility = View.GONE
        cardCellBinding.aspect8Seekbar.visibility = View.GONE
        cardCellBinding.aspect9.visibility = View.GONE
        cardCellBinding.aspect9Seekbar.visibility = View.GONE

        cardCellBinding.headerReps.visibility = View.GONE
        cardCellBinding.headerSets.visibility = View.GONE
//        cardCellBinding.difficulty.visibility = View.GONE

        cardCellBinding.commitReview.visibility = View.INVISIBLE
        cardCellBinding.reviewButton.visibility = View.INVISIBLE

        cardCellBinding.finishedMarker.visibility = View.VISIBLE
//       mainActivity.saveBooleanListToPrefs("session_feedback_list", _session_feedback_left)
//        cardCellBinding.commitReview.text = "Feedback Complete"


    }

    private fun modifyOffset(exercise : String){
//        feedback_offset = 100.0f
        var f = 0.0f
        var feedbackTotal = 0
        if (cardCellBinding.aspect0Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect0Seekbar.progress.toFloat() +0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect1Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect1Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect2Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect2Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect3Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect3Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect4Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect4Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect5Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect5Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect6Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect6Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect7Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect7Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect8Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect8Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }
        if (cardCellBinding.aspect9Seekbar.visibility == View.VISIBLE) {
            f += cardCellBinding.aspect9Seekbar.progress.toFloat()+0.01f
            feedbackTotal += 1
        }

// range is 0-10, default position is 5
        //10 should add double
        if (exercise == "Squat") feedback_offset_squat = ((f/feedbackTotal) ) //feedback_offset_squat = 10-((f-5)/2)
        if (exercise == "Bench") feedback_offset_bench = ((f/feedbackTotal))  //feedback_offset_bench = 10-((f-5)/2)
        if (exercise == "Deadlift") feedback_offset_deadl = ((f/feedbackTotal))  //feedback_offset_deadl = 10-((f-5)/2)
//        Log.d("QM", "Squat offset $feedback_offset_squat, Bench offset $feedback_offset_bench, Deadlift offset $feedback_offset_deadl")

    }

    private fun disableSeekBars(){
        cardCellBinding.aspect0Seekbar.isEnabled = false
        cardCellBinding.aspect1Seekbar.isEnabled = false
        cardCellBinding.aspect2Seekbar.isEnabled = false
        cardCellBinding.aspect3Seekbar.isEnabled = false
        cardCellBinding.aspect4Seekbar.isEnabled = false
        cardCellBinding.aspect5Seekbar.isEnabled = false
        cardCellBinding.aspect6Seekbar.isEnabled = false
        cardCellBinding.aspect7Seekbar.isEnabled = false
        cardCellBinding.aspect8Seekbar.isEnabled = false
        cardCellBinding.aspect9Seekbar.isEnabled = false
    }




}