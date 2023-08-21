package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import com.example.masala_food_recipes.MainActivity
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.util.MyViewModle
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding :: inflate) {

    override fun onCreateView() {

        val child1 = ChildItem("Cuisine", "view all", "CuisineAdapter")
        val child2 = ChildItem("For You", "view all", "ForYouRecipeAdapter")
        val child3 = ChildItem("under 20 min meal", "view all", "UnderTwentyMinAdapter")
        val child4 = ChildItem("under 5 ingredient meal", "view all", "UnderFiveIngredientAdapter")
        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        
        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList)
        }

    }
    override fun onAttach(context : Context)
    {
        super.onAttach(context)
        if (context is MainActivity)
        {
            MyViewModle.mainActivity = context
        }
    }
}