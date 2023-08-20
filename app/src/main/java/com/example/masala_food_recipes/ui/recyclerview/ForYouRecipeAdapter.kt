
package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.RecipeCardBinding
import com.example.masala_food_recipes.util.Constants
import com.example.masala_food_recipes.util.PreferencesUtil

interface ForYouRecipeListener :BaseInteractionListener
class ForYouRecipeAdapter(items: List<List<String>>, listener:ForYouRecipeListener) :BaseRecyclerAdapter<List<String>,BaseRecyclerAdapter.BaseViewHolder<List<String>>>(items, listener) {
    override val layoutId = R.layout.recipe_card

    override fun createViewHolder(view: View): BaseViewHolder<List<String>> = RecipeViewHolder(view)

    class RecipeViewHolder(itemView:View):BaseViewHolder<List<String>>(itemView){

        private val binding = RecipeCardBinding.bind(itemView)
        private val context: Context = itemView.context
        override fun bind(item: List<String>) {
            PreferencesUtil.init(context)
            binding.apply {
                recipeName.text = item[0]
                recipeCuisine.text = item[1]

                Glide.with(context)
                    .load(item[2])
                    .centerCrop()
                    .into(recipeImage)

                checkBox.setOnClickListener {
                    PreferencesUtil.apply {
                        val i = listOf("Cheesy Spinach Open Toast Recipe", "Continental", "https://www.archanaskitchen.com/images/archanaskitchen/1-Author/Farrukh_Aziz_Ansari/Cheesy_Spinach_Open_Toast.jpg")
                        putInSharedPref("pop", item.toString())
                        Log.v("MainActivity", (item.toString()+i).toList().joinToString(""))

//                      putInSharedPref(Constants.KEY_TIME, item[1])
//                        putInSharedPref(Constants.KEY_IMAGE, item[2])
                    }

                }

            }
        }

    }
}