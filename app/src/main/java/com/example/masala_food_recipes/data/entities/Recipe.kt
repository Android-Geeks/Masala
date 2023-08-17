package com.example.masala_food_recipes.data.entities

import android.os.Parcel
import android.os.Parcelable

data class Recipe(
        val translatedRecipeName : String ,
        val translatedIngredients : List<String> ,
        val totalTimeInMin : String ,
        val cuisine : String ,
        val translatedInstructions : List<String> ,
        val url : String ,
        val cleanedIngredients : List<String> ,
        val imageUrl : String ,
        val ingredientCount : String ,
) : Parcelable
{
    constructor(parcel : Parcel) : this(
            parcel.readString()!! ,
            parcel.createStringArrayList()!! ,
            parcel.readString()!! ,
            parcel.readString()!! ,
            parcel.createStringArrayList()!! ,
            parcel.readString()!! ,
            parcel.createStringArrayList()!! ,
            parcel.readString()!! ,
            parcel.readString()!!
    )

    override fun writeToParcel(parcel : Parcel , flags : Int)
    {
        parcel.writeString(translatedRecipeName)
        parcel.writeStringList(translatedIngredients)
        parcel.writeString(totalTimeInMin)
        parcel.writeString(cuisine)
        parcel.writeStringList(translatedInstructions)
        parcel.writeString(url)
        parcel.writeStringList(cleanedIngredients)
        parcel.writeString(imageUrl)
        parcel.writeString(ingredientCount)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Recipe>
    {
        override fun createFromParcel(parcel : Parcel) = Recipe(parcel)

        override fun newArray(size : Int) : Array<Recipe?> = arrayOfNulls(size)
    }
}