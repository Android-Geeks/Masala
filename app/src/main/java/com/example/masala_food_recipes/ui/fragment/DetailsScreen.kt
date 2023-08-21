package com.example.masala_food_recipes.ui.fragment

import android.content.Intent
import android.net.Uri
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.FragmentDetailsScreenBinding
import com.example.masala_food_recipes.ui.recyclerview.PagerAdapter
import com.example.masala_food_recipes.ui.recyclerview.IngredientsScreen
import com.example.masala_food_recipes.ui.recyclerview.InstructionsScreen
import com.google.android.material.tabs.TabLayoutMediator

class DetailsScreen :
    BaseFragment<FragmentDetailsScreenBinding>(FragmentDetailsScreenBinding::inflate) {
    override fun onCreateView() {

        val fakeRecipe by lazy { DataManager(requireContext()).getAllRecipesData()[1] }

        binding.nameRecipe.text = fakeRecipe.translatedRecipeName

        Glide.with(this)
            .load(fakeRecipe.imageUrl)
            .centerCrop()
            .into(binding.recipeImageview)

        binding.recipePrepareTime.text = fakeRecipe.totalTimeInMins.plus(" mins")
        binding.ingredientsCount.text = fakeRecipe.ingredientCount

        binding.moreInfo.setOnClickListener {
            val url = fakeRecipe.url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        val fragments = listOf(
            IngredientsScreen(fakeRecipe.translatedIngredients),
            InstructionsScreen(fakeRecipe.translatedInstructions)
        )
        val tabTitle = listOf("Ingredients", "Instructions")
        val adapter = PagerAdapter(this, fragments)
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }

}