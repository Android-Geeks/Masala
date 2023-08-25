package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.data.interactors.SearchRecipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinRecipe
import com.example.masala_food_recipes.data.listener.HomeFragmentListener
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    HomeFragmentListener {
    private val allRecipes by lazy { DataManager(requireActivity()).getAllRecipesData() }
    private val under20MinList by lazy { UnderTwentyMinRecipe(allRecipes).execute() }
    private val under5IngredientList by lazy { UnderFiveIngredient(allRecipes).execute() }
    private val cuisineList by lazy { Cuisines(allRecipes).getCuisineCards() }
    private val forYouList by lazy { ForYouRecipe(allRecipes).execute() }
    private val searchList by lazy { SearchRecipe(allRecipes).execute() }
    override fun onCreateView() {
        val cuisineNavId = R.id.action_homeFragment_to_cuisineScreenFragment
        val subCategoryNavId = R.id.action_homeFragment_to_fragment_details_screen        //until creating sub category fragment


        val child1 = ChildItem(
            "Cuisine", "View all", "CuisineAdapter",cuisineList, cuisineNavId
        )
        val child2 = ChildItem(
            "For You", "View all", "ForYouRecipeAdapter", forYouList
    , subCategoryNavId
        )
        val child3 = ChildItem(
            "Under 20 min meal", "View all", "UnderTwentyMinAdapter", under20MinList, subCategoryNavId
        )

        val child4 = ChildItem(
            "Under 5 ingredient meal", "View all", "UnderFiveIngredientAdapter", under5IngredientList, subCategoryNavId
        )

        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList , allRecipes)
        }
    }

    override fun onPass(
        cuisineList: List<List<String>>,
        forYouList: List<List<String>>,
        under20MinList: List<List<String>>,
        under5IngredientList: List<List<String>>
    ) {
//        this.cuisineList = cuisineList
//        this.forYouList = forYouList
//        this.under20MinList = under20MinList
//        this.under5IngredientList = under5IngredientList
    }

}