package com.yologames.pwrlftr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
        ): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        if (position ==0)
        {
            return  One_rm_calc()
        }
        if (position ==1)
        {
            return  Rep_Max_Calc()
        }
        else
        {
            return ProgramGenerator()
        }
    }
}