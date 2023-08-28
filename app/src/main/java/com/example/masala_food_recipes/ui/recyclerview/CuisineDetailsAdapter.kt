package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewCuisinesBinding
import com.example.masala_food_recipes.databinding.Under20MinBinding

interface CuisineDetailsListener : BaseInteractionListener

class CuisineDetailsAdapter(items: List<List<String>>, listener: CuisineDetailsListener) :
    BaseRecyclerAdapter<List<String>, BaseRecyclerAdapter.BaseViewHolder<List<String>>>(
        items,
        listener
    ) {
    override val layoutId = R.layout.card_view_cuisines

    override fun createViewHolder(view: View): BaseViewHolder<List<String>>  = CDViewHolder(view)

    inner class CDViewHolder(itemView: View): BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewCuisinesBinding.bind(itemView)
        private val context: Context = itemView.context


        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            binding.apply {
                cuisineTextview.text = item[0]
                itemsCount.text = "${item[1]} min"

                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .into(foodImage)
                foodImage.setOnClickListener{
                    Navigation.findNavController(it).navigate(R.id.action_cuisineDetailsFragment_to_detailsFragment)
                }
            }
        }
    }
}
/*                recipeImage.setOnClickListener {

    val action = HomeFragmentDirections.actionHomeFragmentToFragmentDetailsScreen(
            Details(allRecipes).findRecipe(item[0]))
    Navigation.findNavController(it).navigate(action)
}*/