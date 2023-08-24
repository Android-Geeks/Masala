package com.example.masala_food_recipes


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.data.interactors.Cuisines
import com.example.masala_food_recipes.data.interactors.ForYouRecipe
import com.example.masala_food_recipes.data.interactors.SearchRecipe
import com.example.masala_food_recipes.data.interactors.UnderFiveIngredient
import com.example.masala_food_recipes.data.interactors.UnderTwentyMinRecipe
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.fragment.FavouriteFragment
import com.example.masala_food_recipes.ui.fragment.HomeFragment
import com.example.masala_food_recipes.ui.fragment.SearchFragment
import com.example.masala_food_recipes.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val homeScreen = HomeFragment()
    private val favouriteScreen = FavouriteFragment()
    private val searchScreen = SearchFragment()
    private val settingScreen = SettingFragment()

    private val allRecipes by lazy { DataManager(this).getAllRecipesData() }
    private val under20MinList by lazy { UnderTwentyMinRecipe(allRecipes).execute() }
    private val under5IngredientList by lazy { UnderFiveIngredient(allRecipes).execute() }
    private val cuisineList by lazy { Cuisines(allRecipes).getCuisineCards() }
    private val forYouList by lazy { ForYouRecipe(allRecipes).execute() }
    private val searchList by lazy { SearchRecipe(allRecipes).execute() }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = this.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE)
        if (sharedPref.getBoolean("current_state", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init(savedInstanceState)
    }

    // Navigate Bottom bar  ("look at bottom_nav_menu")
    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container_view)
        binding.bottomNavigation.setupWithNavController(navController)
    }

//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//        if (supportFragmentManager.fragments.last() != homeScreen) backPressed()
//        else {
//            val builder = AlertDialog.Builder(this)
//            builder.setMessage("Are you sure you want to exit?").setCancelable(false)
//                .setPositiveButton("Yes") { _, _ -> finish() }
//                .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
//            val alert = builder.create()
//            alert.show()
//        }
//    }

    private fun init(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            initFragment()
        }
        homeScreen.onPass(
            cuisineList.take(20),
            forYouList.take(20),
            under20MinList.take(20),
            under5IngredientList.take(20)
        )
        searchScreen.onPass(searchList)
//        binding.bottomNavigation.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.homeFragment -> replaceFragment(homeScreen)
//                R.id.settingFragment -> replaceFragment(searchScreen)
//                R.id.favouriteFragment -> replaceFragment(favouriteScreen)
//                R.id.settingFragment -> replaceFragment(settingScreen)
//                else -> false
//            }
//        }
    }

    private fun initFragment() {
        inTransaction {
            add(
                R.id.fragment_container_view, homeScreen
            )
        }
        binding.bottomNavigation.selectedItemId = R.id.homeFragment
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        inTransaction {
            replace(
                R.id.fragment_container_view, fragment
            )
        }
        return true
    }

    private fun inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        supportFragmentManager.beginTransaction().func().commit()
    }

//    private fun backPressed() {
//        initFragment()
//    }
//
//    fun backPressed(view: View) = (view as Toolbar).setNavigationOnClickListener { backPressed() }
}
