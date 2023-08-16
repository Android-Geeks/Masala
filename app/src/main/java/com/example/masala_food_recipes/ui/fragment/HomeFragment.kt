package com.example.masala_food_recipes.ui.fragment

import com.example.masala_food_recipes.ChildItem
import com.example.masala_food_recipes.ParentItem
import com.example.masala_food_recipes.databinding.ParentItemBinding
import com.example.masala_food_recipes.ui.recyclerview.ParentAdapter



class HomeFragment : BaseFragment<ParentItemBinding>(ParentItemBinding :: inflate) {

    override fun onCreateView() {

        val child1 = ChildItem("Cuisine", "view all", "CuisineAdapter")
        val child2 = ChildItem("For You", "view all", "ForYouRecipeAdapter")
        val child3 = ChildItem("under 20 min meal", "view all", "UnderTwentyMinAdapter")
        val child4 = ChildItem("under 5 ingredient meal", "view all", "UnderFiveIngredientAdapter")
        val childList : List<ChildItem> = listOf(child1,child2,child3, child4)


        val p = ParentItem("1", "vo")
//        val p2 = ParentItem("2","sd")
//        val p3 = ParentItem("3","et")

//ممكن اخلى الparent يبقى هو ال RV و الابناء يبقوا هما ال String

        binding.parentRecycler.adapter = ParentAdapter(requireContext() ,listOf(p),childList)
    }
}