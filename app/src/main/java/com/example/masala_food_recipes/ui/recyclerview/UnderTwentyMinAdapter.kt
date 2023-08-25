package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Details
import com.example.masala_food_recipes.databinding.Under20MinBinding
import com.example.masala_food_recipes.ui.fragment.HomeFragmentDirections

interface UnderTwentyMinListener : BaseInteractionListener
class UnderTwentyMinAdapter(
        items : List<List<String>> ,
        listener : UnderTwentyMinListener ,
        private val sharedPref : SharedPreferences ,
        private val allRecipes : List<Recipe>
) : BaseRecyclerAdapter<List<String> , BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items , listener) {
    override val layoutId = R.layout.under_20_min
    val favouriteSet = sharedPref.getStringSet("Favourite" , emptySet())?.toMutableSet()

    override fun createViewHolder(view : View) : BaseViewHolder<List<String>> =
            UnderTwentyViewHolder(view)

    inner class UnderTwentyViewHolder(itemView : View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = Under20MinBinding.bind(itemView)
        private val context : Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item : List<String>) {

            binding.apply {
                reciepeName.text = "${item[0]} min"
                time.text = "${item[1]} min"

                Glide.with(context).load(item[2]).placeholder(R.drawable.loading).centerCrop()
                        .into(image)

                favouriteCheckBox.apply {
                    setOnCheckedChangeListener { _ , isChecked ->
                        if (isChecked) favouriteSet?.add(item[0])
                        else favouriteSet?.remove(item[0])

                        sharedPref.edit().putStringSet("Favourite" , favouriteSet).apply()
                    }
                    isChecked = favouriteSet?.contains(item[0]) == true
                }
                image.setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailsScreen(
                            Details(allRecipes).findRecipe(item[0]))
                    Navigation.findNavController(it).navigate(action)
                }
            }

        }
    }
}