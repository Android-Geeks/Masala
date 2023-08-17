package com.example.masala_food_recipes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.masala_food_recipes.data.entities.Recipe
import com.example.masala_food_recipes.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity()
{
    private lateinit var binding:ActivityDetailsBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val x=intent.getParcelableExtra<Recipe>("recipe")

        if (x != null)
        {
            binding.textview.text=x.translatedRecipeName
        }
    }
}