package com.example.masala_food_recipes.ui.recycler_view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.ViewTarget
import com.bumptech.glide.request.transition.Transition
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.databinding.CuisineCardBinding
import com.example.masala_food_recipes.ui.recyclerview.BaseRecyclerAdapter

class CuisineAdapter(items: List<Recipe>) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items) {
    override val layoutId = R.layout.cuisine_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = CuisineViewHolder(view)

    class CuisineViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CuisineCardBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            binding.apply {
                cuisineName.text = Cuisines(listOf(item)).getCuisineCards().keys.joinToString(",")
                itemNumber.text =
                    Cuisines(listOf(item)).getCuisineCards().values.first().first.toString()
                textItem.text = "item"


                Glide.with(context)
                    .load(Cuisines(listOf(item)).getCuisineCards().values.first().second)
                    .centerCrop()
                    .into(object : ViewTarget<ImageView, Drawable>(cuisineImage) {
                        override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                            cuisineImage.background = resource // Set the background drawable
                        }
                    })
            }
        }
    }
}