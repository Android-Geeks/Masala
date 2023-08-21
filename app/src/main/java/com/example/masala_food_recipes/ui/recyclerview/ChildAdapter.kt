package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinsRecipe
import com.example.masala_food_recipes.databinding.ChildItemBinding

class ChildAdapter(
    private val context: Context,
    private val childList: List<ChildItem>
) : RecyclerView.Adapter<ChildAdapter.PViewHolder>() {

    private val recipeList by lazy { DataManager(context).getAllRecipesData() }
    private val cuisinesList by lazy { Cuisines(recipeList).getCuisineCards() }
    private val forYouList by lazy { ForYouRecipe(recipeList).execute(10) }
    private val underFiveList by lazy { UnderFiveIngredient(recipeList).execute(10) }
    private val underTwentyList by lazy { UnderTwentyMinsRecipe(recipeList).execute(10) }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PViewHolder {
        return PViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PViewHolder, position: Int) {
        val childItem = childList[position]

        holder.binding.apply {
            cuisineText.text = childItem.type
            viewAllText.text = childItem.view_all
            childRecycler.adapter = getAdapter(childItem.adapterType)
        }
    }

    override fun getItemCount(): Int = childList.size

    class PViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ChildItemBinding.bind(itemView)
    }

    private fun getAdapter(adapterType: String): RecyclerView.Adapter<*> {
        return when (adapterType) {
            "CuisineAdapter" -> CuisineAdapter(cuisinesList, object : CuisineListener {
                override fun onClick(position : Int)
                {
//                    TODO("Not yet implemented")
                }
            })

            "ForYouRecipeAdapter" -> ForYouRecipeAdapter(
                forYouList,
                object : ForYouRecipeListener {
                    override fun onClick(position : Int)
                    {
//                        TODO("Not yet implemented")
                    }
                })

            "UnderTwentyMinAdapter" -> UnderTwentyMinAdapter(
                underTwentyList,
                object : UnderTwentyMinListener {
                    override fun onClick(position : Int)
                    {
//                        TODO("Not yet implemented")
                    }
                })

            "UnderFiveIngredientAdapter" -> UnderFiveIngredientAdapter(
                underFiveList,
                object : UnderFiveIngredientListener {
                    override fun onClick(position : Int)
                    {
//                        TODO("Not yet implemented")
                    }
                })

            else -> throw Exception("No Adapter Found")
        }
    }

}