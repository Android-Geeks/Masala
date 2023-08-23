package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.listener.HomeFragmentListener
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    HomeFragmentListener {
    private lateinit var cuisineList: List<List<String>>
    private lateinit var forYouList: List<List<String>>
    private lateinit var under20MinList: List<List<String>>
    private lateinit var under5IngredientList: List<List<String>>

    override fun onCreateView() {

        val child1 = ChildItem(
            "Cuisine", "view all", "CuisineAdapter", cuisineList
        )

        val child2 = ChildItem(
            "For You", "view all", "ForYouRecipeAdapter", forYouList
        )

        val child3 = ChildItem(
            "under 20 min meal", "view all", "UnderTwentyMinAdapter", under20MinList
        )

        val child4 = ChildItem(
            "under 5 ingredient meal", "view all", "UnderFiveIngredientAdapter", under5IngredientList
        )

        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList)
        }
    }

    override fun onPass(
        cuisineList: List<List<String>>,
        forYouList: List<List<String>>,
        under20MinList: List<List<String>>,
        under5IngredientList: List<List<String>>
    ) {
        this.cuisineList = cuisineList
        this.forYouList = forYouList
        this.under20MinList = under20MinList
        this.under5IngredientList = under5IngredientList
    }
}