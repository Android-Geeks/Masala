package com.example.masala_food_recipes.ui.fragment
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.databinding.FragmentHomeBinding
import com.example.masala_food_recipes.ui.recyclerview.ChildAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var cuisineList: List<List<String>>
    private lateinit var forYouList: List<List<String>>
    private lateinit var under20MinList: List<List<String>>
    private lateinit var under5IngredientList: List<List<String>>

    override fun onCreateView() {
        cuisineList = viewModel.cuisineList
        forYouList = viewModel.forYouList
        under20MinList = viewModel.under20MinList
        under5IngredientList = viewModel.under5IngredientList

        val child1 = ChildItem(
            "Cuisine", "View all", "CuisineAdapter", cuisineList
        )

        val child2 = ChildItem(
            "For You", "View all", "ForYouRecipeAdapter", forYouList
        )

        val child3 = ChildItem(
            "Under 20 min meal", "View all", "UnderTwentyMinAdapter", under20MinList
        )

        val child4 = ChildItem(
            "Under 5 ingredient meal",
            "View all",
            "UnderFiveIngredientAdapter",
            under5IngredientList
        )

        val childList: List<ChildItem> = listOf(child1, child2, child3, child4)

        binding.apply {
            parentRecycler.adapter = ChildAdapter(requireContext(), childList)
        }
    }
}