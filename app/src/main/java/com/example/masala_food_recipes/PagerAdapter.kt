package com.example.masala_food_recipes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.masala_food_recipes.ui.fragment.ContainerDetails
import com.example.masala_food_recipes.ui.fragment.DetailsScreen1
import com.example.masala_food_recipes.ui.fragment.DetailsScreen2


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