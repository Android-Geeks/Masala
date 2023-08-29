package com.example.masala_food_recipes.ui.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.R.drawable.baseline_favorite_border_24
import com.example.masala_food_recipes.R.drawable.filled_heart
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentDetailsScreenBinding
import com.example.masala_food_recipes.ui.recyclerview.IngredientsScreen
import com.example.masala_food_recipes.ui.recyclerview.InstructionsScreen
import com.example.masala_food_recipes.ui.recyclerview.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailsScreen :
    BaseFragment<FragmentDetailsScreenBinding>(FragmentDetailsScreenBinding::inflate) {
    override fun onCreateView() {
         lateinit var sharedPref: SharedPreferences

        val favouriteSet = sharedPref.getStringSet("Favourite" , emptySet())?.toMutableSet()

        val fakeRecipe by lazy { DataManager(requireContext()).getAllRecipesData()[0] }

        binding.nameRecipe.text = fakeRecipe.translatedRecipeName

        Glide.with(this)
            .load(fakeRecipe.imageUrl)
            .centerCrop()
            .into(binding.recipeImageview)

        binding.recipePrepareTime.text = fakeRecipe.totalTimeInMins.plus(" mins")
        binding.ingredientsCount.text = fakeRecipe.ingredientCount

        binding.topAppBar.setNavigationOnClickListener {  //TODO

        }


        var previous = true
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_favorite -> {
                    if (previous) {
                        menuItem.setIcon(filled_heart)
                        favouriteSet?.add(fakeRecipe.translatedRecipeName)
                        sharedPref.edit().putStringSet("Favourite",favouriteSet).apply()
                    } else {
                        menuItem.setIcon(baseline_favorite_border_24)
                        favouriteSet?.remove(fakeRecipe.translatedRecipeName)
                        sharedPref.edit().putStringSet("Favourite",favouriteSet).apply()
                    }
                    previous = !previous
                    true
                }
                else ->
                    false

            }
        }

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

