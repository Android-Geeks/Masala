package com.example.masala_food_recipes.ui.recyclerview
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.masala_food_recipes.ui.fragment.ContainerScreen


class PagerAdapter(container: ContainerScreen, private val fragments: List<Fragment>) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int =2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IngredientsScreen()
            1 -> InstructionsScreen()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}