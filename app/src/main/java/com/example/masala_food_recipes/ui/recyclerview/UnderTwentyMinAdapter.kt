package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinsRecipe
import com.example.masala_food_recipes.databinding.CardViewSubCategoryBinding

interface UnderTwentyMinListener : BaseInteractionListener
class UnderTwentyMinAdapter(items: List<Recipe>,listener: UnderTwentyMinListener) :BaseRecyclerAdapter<Recipe,BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.card_view_sub_category

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderTwentyViewHolder(view)

    class UnderTwentyViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underTwentyMinList = UnderTwentyMinsRecipe(listOf(item)).execute(2)

            if (underTwentyMinList.isNotEmpty()) {

                binding.apply {
                    textViewRecipe.text = underTwentyMinList.keys.joinToString(",")
                    minutesText.text = underTwentyMinList.values.first().first.toString()
                    Glide.with(context)
                        .load(underTwentyMinList.values.first().second)
                        .centerCrop()
                        .into(recipeImage)
                }
            }
            else{
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
            }
        }
    }}