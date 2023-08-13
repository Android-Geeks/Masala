package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinsRecipe
import com.example.masala_food_recipes.databinding.UnderTwentyCardBinding

interface UnderTwentyMinListener : BaseInteractionListener
class UnderTwentyMinAdapter(items: List<Recipe>,listener: UnderTwentyMinListener) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.under_twenty_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderTwentyViewHolder(view)

    class UnderTwentyViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = UnderTwentyCardBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underTwentyMinList = UnderTwentyMinsRecipe(listOf(item)).execute(20)

            if (underTwentyMinList.isNotEmpty()) {

                binding.apply {
                    mealName.text = underTwentyMinList.keys.toString()
                    mealTime.text = underTwentyMinList.values.first().first.toString()
                    Glide.with(context)
                        .load(underTwentyMinList.values.first().second)
                        .centerCrop()
                        .into(mealImage)
                }
            }
        }
    }}