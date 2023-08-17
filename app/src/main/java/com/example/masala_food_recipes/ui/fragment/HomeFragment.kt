package com.example.masala_food_recipes.ui.fragment

import android.view.View
import com.example.masala_food_recipes.ChildItem
import com.example.masala_food_recipes.ParentItem
import com.example.masala_food_recipes.databinding.ParentItemBinding
import com.example.masala_food_recipes.ui.recyclerview.ParentAdapter

class HomeFragment : BaseFragment<ParentItemBinding>(ParentItemBinding :: inflate) {

    override fun onCreateView() {

//        val child1 = ChildItem("Cuisine", "view all", "CuisineAdapter")
        val child2 = ChildItem("For You", "view all", "ForYouRecipeAdapter")
        val child3 = ChildItem("under 20 min meal", "view all", "UnderTwentyMinAdapter")
        val child4 = ChildItem("under 5 ingredient meal", "view all", "UnderFiveIngredientAdapter")
        val childList : List<ChildItem> = listOf(child2,child3, child4)


        val parent1 = ParentItem("Cuisine", "View All", "CuisineAdapter")
        val parentList = listOf(parent1)

        binding.apply {     // cause of inflating Parent Item page
            appName.visibility = View.GONE
            headerText.visibility =View.GONE
            viewAllText.visibility = View.GONE
            childRecyclerOfParent.adapter = ParentAdapter(requireContext() , parentList, childList)
        }



    }
}