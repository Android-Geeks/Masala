package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Details
import com.example.masala_food_recipes.data.util.FavouritePreferences
import com.example.masala_food_recipes.databinding.Under20MinBinding
import com.example.masala_food_recipes.ui.fragment.ForYouFragmentDirections
import com.example.masala_food_recipes.ui.fragment.HomeFragmentDirections
import com.example.masala_food_recipes.ui.fragment.UnderFiveIngredientFragmentDirections
import com.example.masala_food_recipes.ui.fragment.UnderTwentyMinFragmentDirections


class SubCategoryAdapter(
    items: List<List<String>>, private val type: String, private val recipeList: List<Recipe>
) : BaseRecyclerAdapter<List<String>, BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
    items
) {

    override val layoutId: Int = R.layout.under_20_min

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> =
        RecipeViewHolder(view)

    inner class RecipeViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                if (type == "ForYou")
                    time.text = "${item[3]} min"
                else
                    time.text = "${item[1]} min"
                Glide.with(itemView).load(item[2]).placeholder(R.drawable.loading).into(image)
                favouriteCheckBox.apply {
                    setOnCheckedChangeListener { _, isChecked ->
                        val favouriteSet = FavouritePreferences.getFromSharedPref()
                        if (isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])
                        FavouritePreferences.putInSharedPref(favouriteSet!!)
                    }
                    this.isChecked =
                        FavouritePreferences.getFromSharedPref()?.contains(item[0]) == true
                }
                itemView.setOnClickListener {
                    when(type)
                    {
                        "ForYou" -> {
                            val action = ForYouFragmentDirections.actionForYouFragmentToDetailsFragment(
                                Details(recipeList).findRecipe(item[0]) !!)
                            Navigation.findNavController(it).navigate(action)
                        }
                        "UnderFive" -> {
                            val action = UnderFiveIngredientFragmentDirections.actionUnderFiveIngredientFragmentToDetailsFragment(
                                Details(recipeList).findRecipe(item[0]) !!)
                            Navigation.findNavController(it).navigate(action)
                        }
                        "UnderTwenty" -> {
                            val action = UnderTwentyMinFragmentDirections.actionUnderTwentyMinFragmentToDetailsFragment(
                                Details(recipeList).findRecipe(item[0]) !!)
                            Navigation.findNavController(it).navigate(action)
                        }
                    }
                }

            }
        }

    }

}
