
package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
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
    private val MAX_ITEMS = 10 // Define the maximum number of items to display

//    override fun getItemCount(): Int {
//        return if (items.size > MAX_ITEMS) {
//            MAX_ITEMS
//        } else {
//            items.size
//        }
//    }

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderFiveViewHolder(view)

    class UnderFiveViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context
        private val limit = 1

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underFiveIngredientList = UnderFiveIngredient(listOf(item)).execute(limit)

            if (underFiveIngredientList.isNotEmpty()&& underFiveIngredientList.size <= limit){
                binding.apply {
                    textViewRecipe.text = underFiveIngredientList.keys.joinToString(",")
                    minutesText.text = underFiveIngredientList.values.first().first.toString()
                    Glide.with(context)
                        .load(underFiveIngredientList.values.first().second)
                        .centerCrop()
                        .into(recipeImage)

                }
            }
            else{
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
            }
        }
    }
}