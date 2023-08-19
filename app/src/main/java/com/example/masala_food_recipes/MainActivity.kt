package com.example.masala_food_recipes


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinRecipe
import com.example.masala_food_recipes.data.util.MyViewModle
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.fragment.FavouriteFragment
import com.example.masala_food_recipes.ui.fragment.HomeFragment
import com.example.masala_food_recipes.ui.fragment.SearchFragment
import com.example.masala_food_recipes.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    private val homeScreen = HomeFragment()
    private val favouriteScreen = FavouriteFragment()
    private val searchScreen = SearchFragment()
    private val settingScreen = SettingFragment()
    override fun onCreate(savedInstanceState : Bundle?)
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState : Bundle?)
    {
        if (savedInstanceState == null)
        {
            MyViewModle.apply {
                allRecipes = DataManager(this@MainActivity).getAllRecipesData()
                under20MinList = UnderTwentyMinRecipe(allRecipes).execute()
                under5IngredientList = UnderFiveIngredient(allRecipes).execute()
                cuisineList = Cuisines(allRecipes).getCuisineCards()
                forYouList = ForYouRecipe(allRecipes).execute(10)
            }
            val sharedPref = this.getSharedPreferences("MY_PREFS" , Context.MODE_PRIVATE)
            if (sharedPref.getBoolean("current_state" , false))
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
        initFragment()
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId)
            {
                R.id.home_icon      -> replaceFragment(homeScreen , R.layout.main_app_bar)
                R.id.search_icon    -> replaceFragment(searchScreen , R.layout.main_app_bar)
                R.id.favourite_icon -> replaceFragment(favouriteScreen , R.layout.favourite_app_bar)
                R.id.setting_icon   -> replaceFragment(settingScreen , null)
                else                -> false
            }
        }
    }

    private fun initFragment()
    {
        changeAppBar(R.layout.main_app_bar)
        inTransaction { replace(R.id.fragment_container_view , homeScreen) }
    }

    private fun replaceFragment(fragment : Fragment , appBar : Int?) : Boolean
    {
        inTransaction { replace(R.id.fragment_container_view , fragment) }
        changeAppBar(appBar)
        return true
    }


    private fun inTransaction(func : FragmentTransaction.() -> FragmentTransaction)
    {
        supportFragmentManager
                .beginTransaction()
                .func()
                .commit()
    }

    private fun changeAppBar(appBar : Int?)
    {
        val appBarContainer = binding.appBar
        appBarContainer.removeAllViews()
        if (appBar != null)
        {
            val inflater = LayoutInflater.from(this)
            val newAppBar = inflater.inflate(appBar , appBarContainer , false)
            appBarContainer.addView(newAppBar)
        }

    }

}