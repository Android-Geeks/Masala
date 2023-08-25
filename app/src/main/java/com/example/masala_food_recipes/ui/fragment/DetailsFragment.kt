package com.example.masala_food_recipes.ui.fragment

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.R.drawable.baseline_favorite_border_24
import com.example.masala_food_recipes.R.drawable.filled_heart
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentDetailsBinding
import com.example.masala_food_recipes.ui.recyclerview.IngredientsScreen
import com.example.masala_food_recipes.ui.recyclerview.InstructionsScreen
import com.example.masala_food_recipes.ui.recyclerview.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailsFragment :
    BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    override fun onCreateView() {
        val args:DetailsFragmentArgs by navArgs()
        val fakeRecipe =args.recipe

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
                    } else {
                        menuItem.setIcon(baseline_favorite_border_24)
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

        binding.topAppBar.setNavigationOnClickListener {v->
            navTo("back", v, null)
        }
    }


}

