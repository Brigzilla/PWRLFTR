package com.yologames.pwrlftr

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yologames.pwrlftr.databinding.FragmentProgramGeneratorBinding
import com.yologames.pwrlftr.recyclerview.PCard
import com.yologames.pwrlftr.recyclerview.PCardAdapter
import com.yologames.pwrlftr.recyclerview.PCardList
private lateinit var binding: FragmentProgramGeneratorBinding
class ProgramGenerator : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_program_generator, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        PopulateCards()
        InitRecycler()
    }


    fun InitRecycler(){
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context, 1)
            adapter = PCardAdapter(PCardList)
        }
    }

    private fun PopulateCards() {
        ClearCards()
        var i = 0
        while (i<100)
        {
            val cardToAdd = PCard(
                "TITLE" + i,
                "EXERCISE",
                "SETS"+i,
                "REPS",
                i
            )
            PCardList.add(cardToAdd)
            i++
        }
    }

    private fun ClearCards() {
        PCardList.clear()
    }

}