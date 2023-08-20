
package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewSubCategoryBinding
import com.example.masala_food_recipes.util.Constants
import com.example.masala_food_recipes.util.PreferencesUtil


interface UnderFiveIngredientListener : BaseInteractionListener

class UnderFiveIngredientAdapter(items: List<List<String>>, listener:UnderFiveIngredientListener) :
    BaseRecyclerAdapter<List<String>, BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
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

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = UnderFiveViewHolder(view)
    class UnderFiveViewHolder(itemView: View) : BaseViewHolder<List<String>>(itemView) {
        private val binding = CardViewSubCategoryBinding.bind(itemView)
        private val context: Context = itemView.context

        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {

            if (item.isNotEmpty()){
                binding.apply {
                    textViewRecipe.text = "${item[0]} min"
                    minutesText.text = "${item[1]} min"
                    Glide.with(context)
                        .load(item[2])
                        .centerCrop()
                        .into(recipeImage)
                    drawableFavorite.setOnClickListener {
                        PreferencesUtil.apply {
                            putInSharedPref(Constants.KEY_NAME, item[0])
                            putInSharedPref(Constants.KEY_TIME, item[1])
                            putInSharedPref(Constants.KEY_IMAGE, item[2])
                        }

                    }
                }
                }
                else{
                    itemView.visibility = View.GONE
                    itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
                }
            }
        }
}