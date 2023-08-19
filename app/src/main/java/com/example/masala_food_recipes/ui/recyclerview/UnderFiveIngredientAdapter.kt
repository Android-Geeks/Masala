
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


interface UnderFiveIngredientListener : BaseInteractionListener

class UnderFiveIngredientAdapter(items: List<Recipe>, listener:UnderFiveIngredientListener) :
    BaseRecyclerAdapter<Recipe, BaseRecyclerAdapter.BaseViewHolder<Recipe>>(items, listener) {
    override val layoutId = R.layout.card_view_sub_category

//    private val maxItems = 10 // Define the maximum number of items to display
//
//    override fun getItemCount(): Int {
//        return if (items.size > maxItems) {
//            maxItems
//        } else {
//            items.size
//        }
//    }

    override fun createViewHolder(view: View): BaseViewHolder<Recipe> = UnderFiveViewHolder(view)

    class UnderFiveViewHolder(itemView: View) : BaseViewHolder<Recipe>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: Recipe) {
            val underFiveIngredient = UnderFiveIngredient(listOf(item)).execute()

            if (underFiveIngredient.isNotEmpty()){
                val under5List = underFiveIngredient[0]
                binding.apply {
                    textViewRecipe.text = under5List[0]
                    minutesText.text = under5List[1]
                    Glide.with(context)
                        .load(under5List[2])
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