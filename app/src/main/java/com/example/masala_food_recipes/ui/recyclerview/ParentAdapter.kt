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
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinsRecipe
import com.example.masala_food_recipes.databinding.ParentItemBinding
import java.lang.Exception

class ParentAdapter(
    private val context: Context,
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
            childRecyclerOfParent.adapter = ChildAdapter(context,childList, recipeList)
            parentRecycler.adapter = getAdapter(parentItem.adapterType)
        }

    }


    override fun getItemCount(): Int = parentList.size

    class PViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ParentItemBinding.bind(itemView)
    }

    private fun getAdapter(adapterType: String): RecyclerView.Adapter<*> {
        val cuisinesList = Cuisines(DataManager(context).getAllRecipesData()).getCuisineCards()
        val underFiveList = UnderFiveIngredient(DataManager(context).getAllRecipesData()).execute()
        val underTwentyList = UnderTwentyMinsRecipe(DataManager(context).getAllRecipesData()).execute()
        return when (adapterType) {
            "CuisineAdapter" -> CuisineAdapter(cuisinesList, object : CuisineListener {})

            "ForYouRecipeAdapter" -> ForYouRecipeAdapter(recipeList, object : ForYouRecipeListener {})

            "UnderTwentyMinAdapter" -> UnderTwentyMinAdapter(underTwentyList, object : UnderTwentyMinListener {})

            "UnderFiveIngredientAdapter" -> UnderFiveIngredientAdapter(underFiveList, object : UnderFiveIngredientListener {})

            else -> throw Exception("No Adapter Found")
        }
    }
}