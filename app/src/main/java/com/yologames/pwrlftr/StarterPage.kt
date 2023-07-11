package com.yologames.pwrlftr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yologames.pwrlftr.databinding.FragmentStarterPageBinding
import com.yologames.pwrlftr.room.StarterPageViewModel

class StarterPage : Fragment() {


    private val viewModel: StarterPageViewModel by viewModels()

    private lateinit var binding: FragmentStarterPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_starter_page, container, false)
        return binding.root


    }

}