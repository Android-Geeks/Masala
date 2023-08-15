package com.example.masala_food_recipes


import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.fragment.FavouriteFragment
import com.example.masala_food_recipes.ui.fragment.HomeFragment
import com.example.masala_food_recipes.ui.fragment.SearchFragment
import com.example.masala_food_recipes.ui.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeScreen = HomeFragment()
    private val favouriteScreen = FavouriteFragment()
    private val searchScreen = SearchFragment()
    private val settingScreen = SettingFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeAppBar(R.layout.main_app_bar)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState:Bundle?) {
        if (savedInstanceState == null) {
            initFragment()
        }
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_icon -> replaceFragment(homeScreen)
                R.id.search_icon -> replaceFragment(searchScreen)
                R.id.favourite_icon -> replaceFragment(favouriteScreen)
                R.id.setting_icon -> replaceFragment(settingScreen)
                else -> false
            }
        }
    }

    private fun initFragment() {
        inTransaction { replace(R.id.fragment_container_view, homeScreen) }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        inTransaction { replace(R.id.fragment_container_view, fragment) }
        return true
    }


    private fun inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        supportFragmentManager
            .beginTransaction()
            .func()
            .commit()
    }

    private fun changeAppBar(appBar : Int) {
        val appBarContainer = binding.appBar
        appBarContainer.removeAllViews()
        val inflater = LayoutInflater.from(this)
        val newAppBar = inflater.inflate(appBar , appBarContainer , false)
        appBarContainer.addView(newAppBar)

    }

}