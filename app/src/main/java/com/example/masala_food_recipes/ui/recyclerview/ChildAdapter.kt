package com.example.masala_food_recipes.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.data.entities.ChildItem
import com.example.masala_food_recipes.data.interactors.goToDetails
import com.example.masala_food_recipes.data.util.MyViewModle
import com.example.masala_food_recipes.databinding.ChildItemBinding

class ChildAdapter(
        private val context : Context ,
        private val childList : List<ChildItem>
) : RecyclerView.Adapter<ChildAdapter.PViewHolder>() {
    override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : PViewHolder {
        return PViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.child_item , parent , false)
        )
    }

    override fun onBindViewHolder(holder : PViewHolder , position : Int) {
        val childItem = childList[position]

        holder.binding.apply {
            cuisineText.text = childItem.type
            viewAllText.text = childItem.view_all
            childRecycler.adapter = getAdapter(childItem.adapterType)
        }
    }

    override fun getItemCount() : Int = childList.size

    class PViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val binding = ChildItemBinding.bind(itemView)
    }

    private fun getAdapter(adapterType : String) : RecyclerView.Adapter<*> {
        return when (adapterType) {
            "CuisineAdapter" -> CuisineAdapter(
                MyViewModle.cuisineList.take(10) ,
                object : CuisineListener {
                    override fun onClick(position : Int) {
                        //                    TODO("Not yet implemented")
                    }
                })

            "ForYouRecipeAdapter" -> ForYouRecipeAdapter(
                MyViewModle.forYouList ,
                object : ForYouRecipeListener {
                    override fun onClick(position : Int) {
                        goToDetails(
                            MyViewModle.allRecipes.find { MyViewModle.forYouList[position][0] == it.translatedRecipeName }!!
                        )
                    }
                })

            "UnderTwentyMinAdapter" -> UnderTwentyMinAdapter(
                MyViewModle.under20MinList.take(10) ,
                object : UnderTwentyMinListener {
                    override fun onClick(position : Int) {
                        goToDetails(
                            MyViewModle.allRecipes.find { MyViewModle.under20MinList[position][0] == it.translatedRecipeName }!!
                        )
                    }
                })

            "UnderFiveIngredientAdapter" -> UnderFiveIngredientAdapter(
                MyViewModle.under5IngredientList.take(10) ,
                object : UnderFiveIngredientListener {
                    override fun onClick(position : Int) {
                        goToDetails(
                            MyViewModle.allRecipes.find { MyViewModle.under5IngredientList[position][0] == it.translatedRecipeName }!!
                        )
                    }
                })

            else -> throw Exception("No Adapter Found")
        }
    }

}