package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.FragmentDetailsBinding
import com.example.masala_food_recipes.ui.recyclerview.IngredientsScreen
import com.example.masala_food_recipes.ui.recyclerview.InstructionsScreen
import com.example.masala_food_recipes.ui.recyclerview.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    override fun onCreateView() {
        val args: DetailsFragmentArgs by navArgs()
        val fakeRecipe = args.recipe

        val sharedPref: SharedPreferences = requireContext().getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE)
        val favouriteSet = sharedPref.getStringSet("Favourite", emptySet())?.toMutableSet()

        binding.nameRecipe.text = fakeRecipe.translatedRecipeName

        Glide.with(this)
            .load(fakeRecipe.imageUrl)
            .centerCrop()
            .into(binding.recipeImageview)

        binding.recipePrepareTime.text = fakeRecipe.totalTimeInMins.plus(" mins")
        binding.ingredientsCount.text = fakeRecipe.ingredientCount

        var previous = true
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_favorite -> {
                    if (previous) {
                        menuItem.setIcon(R.drawable.favorite_icon)
                        favouriteSet?.add(fakeRecipe.translatedRecipeName)
                    } else {
                        menuItem.setIcon(R.drawable.baseline_favorite_border_24)
                        favouriteSet?.remove(fakeRecipe.translatedRecipeName)
                    }
                    sharedPref.edit().putStringSet("Favourite", favouriteSet).apply()
                    previous = !previous
                    true
                }

                else ->
                    false

            }
        }

        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.moreInfo.setOnClickListener {
            val url = fakeRecipe.url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        viewModel.ingredients = fakeRecipe.cleanedIngredients
        viewModel.instructions = fakeRecipe.translatedInstructions
        val fragments = listOf(
            IngredientsScreen(), InstructionsScreen()
        )
        val tabTitle = listOf("Ingredients", "Instructions")
        val adapter = PagerAdapter(this, fragments)
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()

    }
}
