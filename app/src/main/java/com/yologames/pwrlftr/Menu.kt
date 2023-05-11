package com.yologames.pwrlftr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class Menu : Fragment() {
    lateinit var b_onerm: Button
    lateinit var r_repmx: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        b_onerm = view.findViewById(R.id.one_rm_calc)
        r_repmx = view.findViewById(R.id.rep_max_calc)

        setOnClickListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    fun setOnClickListeners(){
        b_onerm.setOnClickListener{
            findNavController().navigate(R.id.action_menu_to_one_rm_calc)
        }
        r_repmx.setOnClickListener{
            findNavController().navigate(R.id.action_menu_to_rep_Max_Calc)
        }
    }



}