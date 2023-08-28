package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.ChildItemBinding

class ChildAdapter(
    private val context : Context,
    private val childList : List<ChildItem>,
    private val recipeList : List<Recipe>
) : RecyclerView.Adapter<ChildAdapter.PViewHolder>() {

    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : PViewHolder {
        return PViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.child_item , parent , false))
    }

    override fun onBindViewHolder(holder : PViewHolder , position : Int) {
        val childItem = childList[position]

        holder.binding.apply {
            cuisineText.text = childItem.type
            viewAllText.text = childItem.view_all
            childRecycler.addItemDecoration(FirstItemPaddingDecoration(16,childItem.list.size-1))
            childRecycler.adapter = getAdapter(childItem.adapterType , childItem.list)
            viewAllText.setOnClickListener {
                findNavController(it).navigate(childItem.navToID)
            }
        }
    }

    override fun getItemCount() : Int = childList.size

    class PViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = ChildItemBinding.bind(itemView)
    }

    private fun getAdapter(
            adapterType : String , list : List<List<String>>
    ) : RecyclerView.Adapter<*> {
        return when (adapterType) {
            "CuisineAdapter" -> CuisineAdapter(list , object : CuisineListener {
                override fun onClick(position : Int) {
                //                    TODO("Not yet implemented")
                }
            })

            "ForYouRecipeAdapter" -> ForYouRecipeAdapter(list , object : ForYouRecipeListener {
                override fun onClick(position : Int) {
                }
            },context.getSharedPreferences("Favourites", Context.MODE_PRIVATE),
                recipeList)

            "UnderTwentyMinAdapter" -> UnderTwentyMinAdapter(list ,
                    object : UnderTwentyMinListener {
                        override fun onClick(position : Int) {
                        }
                    },context.getSharedPreferences("Favourites", Context.MODE_PRIVATE),
                recipeList)

            "UnderFiveIngredientAdapter" -> UnderFiveIngredientAdapter(list ,
                    object : UnderFiveIngredientListener {
                        override fun onClick(position : Int) {
                        }
                    },context.getSharedPreferences("Favourites", Context.MODE_PRIVATE),
                recipeList)

            else -> throw Exception("No Adapter Found")
        }
    }

}