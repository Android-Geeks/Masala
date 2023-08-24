package com.example.masala_food_recipes.ui.fragment

import androidx.navigation.Navigation
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding :: inflate) {

    override fun onCreateView() {
        val cuisineFragmentID = R.id.action_homeFragment_to_cuisineScreenFragment
        val subCategory = R.id.action_homeFragment_to_favouriteFragment2       // until creating sub category fragment
        val child1 = ChildItem("Cuisine", "view all", "CuisineAdapter", cuisineFragmentID)
        val child2 = ChildItem("For You", "view all", "ForYouRecipeAdapter", subCategory)
        val child3 = ChildItem("under 20 min meal", "view all", "UnderTwentyMinAdapter", subCategory)
        val child4 = ChildItem("under 5 ingredient meal", "view all", "UnderFiveIngredientAdapter", subCategory)
        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        
        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList)
            }
        }

}