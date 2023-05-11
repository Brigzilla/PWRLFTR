package com.yologames.pwrlftr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Rep_Max_Calc : Fragment() {

    lateinit var input_reps_box : TextView
    lateinit var input_weight_box: TextView
    lateinit var calculate_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rep__max__calc, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        calculate_button  = view.findViewById(R.id.calculate_1rm_button)
        input_reps_box = view.findViewById(R.id.enter_reps_textbox)
        input_weight_box = view.findViewById(R.id.enter_weight_textbox)
        super.onViewCreated(view, savedInstanceState)

    }


    fun calculateOneRepMax(weight: Int, reps: Int): Int{
        var one_rm: Int = 0

       return one_rm
    }
}