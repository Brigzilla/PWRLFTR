package com.yologames.pwrlftr

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.findFragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout


class Menu : Fragment() {
    lateinit var b_onerm: Button
    lateinit var r_repmx: Button

    val NUM_PAGES : Int = 2
    lateinit var viewpager : ViewPager2
    lateinit var tabLayout : TabLayout
    lateinit var adapter : FragmentPageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        tabLayout = view.findViewById(R.id.tab_layout)
        viewpager = view.findViewById(R.id.pager)
        adapter = FragmentPageAdapter(requireActivity().supportFragmentManager, lifecycle)
        tabLayout.addTab(tabLayout.newTab().setText("One Rep Max"))
        tabLayout.addTab(tabLayout.newTab().setText("Rep Maxes"))
        tabLayout.addTab(tabLayout.newTab().setText("Program Generator"))
        viewpager.adapter = adapter

        tabLayout.addOnTabSelectedListener(object  : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        }
        )
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })


        setOnClickListeners()
        super.onViewCreated(view, savedInstanceState)
    }


    fun setOnClickListeners(){

    }



}