package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.ui.recyclerview.PagerAdapter
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.FragmentContainerScreenBinding
import com.example.masala_food_recipes.ui.recyclerview.IngredientsScreen
import com.example.masala_food_recipes.ui.recyclerview.InstructionsScreen
import com.google.android.material.tabs.TabLayoutMediator

class ContainerScreen :
    BaseFragment<FragmentContainerScreenBinding>(FragmentContainerScreenBinding::inflate) {
    override fun onCreateView() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.details_screen, DetailsScreen())
        transaction.addToBackStack(null)
        transaction.commit()

        val fragments = listOf(IngredientsScreen(), InstructionsScreen())
        val tabTitle = listOf("Ingredients" , "Instructions")
        val adapter = PagerAdapter(this,fragments)
        binding.viewpager.adapter = adapter


        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->

          tab.text = tabTitle[position]
        }.attach()

    }

}