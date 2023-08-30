package com.example.masala_food_recipes.ui.recyclerview
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.masala_food_recipes.ui.fragment.DetailsFragment

class PagerAdapter(container: DetailsFragment, private val fragments: List<Fragment>) : FragmentStateAdapter(container) {

    override fun getItemCount(): Int =2
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragments[0]
            1 -> fragments[1]
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

}