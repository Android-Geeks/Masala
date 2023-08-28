package com.example.masala_food_recipes.ui.fragment
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var cuisineList: List<List<String>>
    private lateinit var forYouList: List<List<String>>
    private lateinit var under20MinList: List<List<String>>
    private lateinit var under5IngredientList: List<List<String>>
    private lateinit var recipeList : List<Recipe>

    override fun onCreateView() {
        cuisineList = viewModel.cuisineList
        forYouList = viewModel.forYouList
        under20MinList = viewModel.under20MinList
        under5IngredientList = viewModel.under5IngredientList
        recipeList = viewModel.recipes

        val cuisineNavID = R.id.action_homeFragment_to_cuisineScreenFragment
        val forYouNavID = R.id.action_homeFragment_to_forYouFragment
        val inder5NavID = R.id.action_homeFragment_to_underFiveIngredientFragment
        val inder20NavID = R.id.action_homeFragment_to_underTwentyMinFragment
        val child1 = ChildItem(
            "Cuisine", "View all", "CuisineAdapter", cuisineList, cuisineNavID)

        val child2 = ChildItem(
            "For You", "View all", "ForYouRecipeAdapter", forYouList, forYouNavID
        )

        val child3 = ChildItem(
            "Under 20 min meal", "View all", "UnderTwentyMinAdapter", under20MinList, inder20NavID
        )

        val child4 = ChildItem(
            "Under 5 ingredient meal","View all","UnderFiveIngredientAdapter", under5IngredientList, inder5NavID
        )

        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList, recipeList)
        }
    }
}