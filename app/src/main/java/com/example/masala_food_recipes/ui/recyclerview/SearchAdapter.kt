package com.example.masala_food_recipes.ui.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.CardViewSearchBinding

interface SearchListener : BaseInteractionListener

class SearchAdapter(items: List<List<String>>, listener:SearchListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId = R.layout.card_view_search

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = RecipeViewHolder(view)

    class RecipeViewHolder(itemView: View):BaseViewHolder<List<String>>(itemView){

        private val binding = CardViewSearchBinding.bind(itemView)
        private val context: Context = itemView.context
        @SuppressLint("SetTextI18n")
        override fun bind(item: List<String>) {
            if (item.isNotEmpty()) {
                binding.apply {
                    recipeText.text = item[0]
                    minutesText.text = item[1] + " min"


                    Glide.with(context)
                        .load(item[2])
                        .centerCrop()
                        .into(itemImage)

                }
            }else{
                itemView.visibility = View.GONE
                itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
            }
        }

    }
}