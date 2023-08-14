
package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.databinding.CardViewSubCategoryBinding


interface UnderFiveIngredientListener : BaseInteractionListener{
    fun doNothing() {
        // Empty implementation
    }
}

class UnderFiveIngredientAdapter(items: List<Recipe>, listener:UnderFiveIngredientListener) :
    BaseRecyclerAdapter<Recipe, BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.card_view_sub_category

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderFiveViewHolder(view)

    class UnderFiveViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underFiveIngredientList = UnderFiveIngredient(listOf(item)).execute(20)

            if (underFiveIngredientList.isNotEmpty()){

                binding.apply {
                    textViewRecipe.text = underFiveIngredientList.keys.joinToString(",")
                    minutesText.text = underFiveIngredientList.values.first().first.toString()
                    Glide.with(context)
                        .load(underFiveIngredientList.values.first().second)
                        .centerCrop()
                        .into(recipeImage)

                }
            }
        }
    }
}