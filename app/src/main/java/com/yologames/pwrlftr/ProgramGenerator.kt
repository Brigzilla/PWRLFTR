package com.yologames.pwrlftr

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardAdapter
import com.yologames.pwrlftr.recyclerview.PCardList
lateinit var recycler : RecyclerView
class ProgramGenerator : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_program_generator, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        PopulateCards()
        InitRecycler()
    }


    fun InitRecycler(){
        recycler = requireView().findViewById(R.id.recycler_view)
        recycler.apply {
            layoutManager = GridLayoutManager(this.context, 1)
            adapter = PCardAdapter(PCardList)
        }
//        recycler.adapter = PCardAdapter(
//            PCardList
//        )
    }

    private fun PopulateCards() {
        ClearCards()
        var i = 0
        while (i<10)
        {
            val cardToAdd = PCard(
                "TITLE",
                "EXERCISE",
                "SETS",
                "REPS",
                i
            )

            PCardList.add(cardToAdd)
            i++
            Log.d("PGR", i.toString())
        }
    }

    private fun ClearCards() {
        PCardList.clear()
    }

}