package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.CuisineAdapter
import com.example.masala_food_recipes.ui.recyclerview.CuisineListener
import com.example.masala_food_recipes.ui.recyclerview.ForYouRecipeAdapter
import com.example.masala_food_recipes.ui.recyclerview.ForYouRecipeListener
import com.example.masala_food_recipes.ui.recyclerview.UnderFiveIngredientAdapter
import com.example.masala_food_recipes.ui.recyclerview.UnderFiveIngredientListener
import com.example.masala_food_recipes.ui.recyclerview.UnderTwentyMinAdapter
import com.example.masala_food_recipes.ui.recyclerview.UnderTwentyMinListener

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding :: inflate) {

    override fun onCreateView() {
        val recipeList = DataManager(requireContext()).getAllRecipesData()

        binding.cuisineRecycler.adapter = CuisineAdapter(recipeList,object : CuisineListener {})


        binding.recipeRecycler.adapter = ForYouRecipeAdapter(recipeList,object : ForYouRecipeListener{})

        binding.underFiveRecycler.adapter = UnderFiveIngredientAdapter(recipeList,object :UnderFiveIngredientListener{})
        binding.underTwentyRecycler.adapter = UnderTwentyMinAdapter(recipeList,object :UnderTwentyMinListener{})
    }
}