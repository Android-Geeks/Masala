package com.example.masala_food_recipes.ui.fragment

import androidx.viewpager2.widget.ViewPager2
import com.example.masala_food_recipes.PagerAdapter
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.FragmentContainerDetailsBinding

class ContainerDetails :
    BaseFragment<FragmentContainerDetailsBinding>(FragmentContainerDetailsBinding::inflate) {
    override fun onCreateView() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.details_screen, DetailsScreen())
        transaction.addToBackStack(null)
        transaction.commit()

        lateinit var viewPager: ViewPager2
        val fragments = listOf(DetailsScreen1(), DetailsScreen2())
        val adapter = PagerAdapter(this, fragments)
        viewPager = binding.viewpager
        viewPager.adapter = adapter
    }

}