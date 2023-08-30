package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Details
import com.example.masala_food_recipes.data.util.FavouritePreferences
import com.example.masala_food_recipes.databinding.Under20MinBinding
import com.example.masala_food_recipes.ui.fragment.CuisineDetailsFragmentDirections

class CuisineDetailsAdapter(items : List<List<String>> , val recipeList : List<Recipe>) :
    BaseRecyclerAdapter<List<String> , BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
            items) {
    override val layoutId = R.layout.under_20_min

    override fun createViewHolder(view : View) : BaseViewHolder<List<String>> = CDViewHolder(view)

    inner class CDViewHolder(itemView : View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)
        private val context : Context = itemView.context


        @SuppressLint("SetTextI18n")
        override fun bind(item : List<String>) {
            binding.apply {
                reciepeName.text = item[0]
                time.text = "${item[1]} min"

                Glide.with(context).load(item[2]).centerCrop().placeholder(R.drawable.loading)
                        .into(image)
                favouriteCheckBox.apply {
                    setOnCheckedChangeListener { _ , isChecked ->
                        val favouriteSet = FavouritePreferences.getFromSharedPref()
                        if (isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])
                        FavouritePreferences.putInSharedPref(favouriteSet !!)
                    }
                    this.isChecked =
                        FavouritePreferences.getFromSharedPref()?.contains(item[0]) == true
                }
                under20min.setOnClickListener {
                    val action =
                            CuisineDetailsFragmentDirections.actionCuisineDetailsFragmentToDetailsFragment(
                                    Details(recipeList).findRecipe(item[0]) !!)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
}
