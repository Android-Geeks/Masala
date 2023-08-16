package com.example.masala_food_recipes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class PagerAdapter(container: ContainerDetails, private val fragments: List<Fragment>) : FragmentStateAdapter(container) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DetailsScreen1()
            1 -> DetailsScreen2()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }


    }
}