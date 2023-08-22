package com.example.masala_food_recipes.data.interactors

import android.os.Bundle
import com.example.masala_food_recipes.MainActivity
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.ui.fragment.DetailsFragment

fun goToDetails(recipe : Recipe) {
    val details = DetailsFragment()
    val bundle = Bundle()
    bundle.putParcelable("recipe" , recipe)
    details.arguments = bundle
    val mainActivity = MainActivity.getInstance()
    mainActivity.inTransaction { replace(R.id.fragment_container_view , details) }
    mainActivity.changeAppBar(R.layout.sub_app_bar)
}