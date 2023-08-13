package com.example.masala_food_recipes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.DetailsScreen2


class PagerAdapter(container: FragmentActivity, private val fragments : List<Fragment>) : FragmentStateAdapter(container) {
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailsScreen1()
            1 -> DetailsScreen2()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }


    }
}