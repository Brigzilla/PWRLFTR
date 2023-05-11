package com.yologames.pwrlftr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class Menu : Fragment() {
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        button = view.findViewById(R.id.button)

        setOnClickListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    fun setOnClickListeners(){
        button.setOnClickListener{
            findNavController().navigate(R.id.action_menu_to_one_rm_calc)
        }
    }



}