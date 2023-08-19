package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.entities.ParentItem
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.ParentItemBinding
import java.lang.Exception

class ParentAdapter(
    context: Context,
    private val parentList: List<ParentItem>,
    private val childList: List<ChildItem>
) : RecyclerView.Adapter<ParentAdapter.PViewHolder>() {

    private val recipeList = DataManager(context).getAllRecipesData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PViewHolder {
        return PViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PViewHolder, position: Int) {
        val parentItem = parentList[position]

        holder.binding.apply {
            headerText.text = parentItem.type
            childRecyclerOfParent.adapter = ChildAdapter(childList, recipeList)
            parentRecycler.adapter = getAdapter(parentItem.adapterType)
        }

    }


    override fun getItemCount(): Int = parentList.size

    class PViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ParentItemBinding.bind(itemView)
    }

    private fun getAdapter(adapterType: String): RecyclerView.Adapter<*> {
        return when (adapterType) {
            "CuisineAdapter" -> CuisineAdapter(recipeList, object : CuisineListener {})

            "ForYouRecipeAdapter" -> ForYouRecipeAdapter(recipeList, object : ForYouRecipeListener {})

            "UnderTwentyMinAdapter" -> UnderTwentyMinAdapter(recipeList, object : UnderTwentyMinListener {})

            "UnderFiveIngredientAdapter" -> UnderFiveIngredientAdapter(recipeList, object : UnderFiveIngredientListener {})

            else -> throw Exception("No Adapter Found")
        }
    }
}