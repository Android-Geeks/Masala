
package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.databinding.UnderFiveIngredientCardBinding

interface UnderFiveIngredientListener : BaseInteractionListener{
    fun doNothing() {
        // Empty implementation
    }
}

class UnderFiveIngredientAdapter(items: List<Recipe>, listener:UnderFiveIngredientListener) :
    BaseRecyclerAdapter<Recipe, BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.under_five_ingredient_card

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderFiveViewHolder(view)

    class UnderFiveViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = UnderFiveIngredientCardBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underFiveIngredientList = UnderFiveIngredient(listOf(item)).execute(20)

            if (underFiveIngredientList.isNotEmpty()){

                val underFiveIngredient = underFiveIngredientList.first()
                binding.apply {
                    mealName.text = underFiveIngredient.first
                    mealTime.text = underFiveIngredient.second.first
                    Glide.with(context)
                        .load(underFiveIngredient.second.second)
                        .centerCrop()
                        .into(mealImage)

                }
            }
        }
    }
}