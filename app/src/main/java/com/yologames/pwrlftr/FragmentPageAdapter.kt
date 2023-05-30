package com.yologames.pwrlftr

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class FragmentPageAdapter (
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
        ): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position ==0)
        {
            One_rm_calc()
        }
        else {
            Rep_Max_Calc()
        }
    }


}