package com.example.masala_food_recipes.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.masala_food_recipes.R
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.fragment.FavouriteFragment
import com.example.masala_food_recipes.ui.fragment.HomeFragment
import com.example.masala_food_recipes.ui.fragment.SearchFragment
import com.example.masala_food_recipes.ui.fragment.SettingFragment

abstract class InitClass : AppCompatActivity() {
    protected lateinit var binding : ActivityMainBinding
    protected val homeScreen = HomeFragment()
    protected val favouriteScreen = FavouriteFragment()
    protected val searchScreen = SearchFragment()
    protected val settingScreen = SettingFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }
    private fun init() {
        initFragment()
        binding.bottomNavigation.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.home_icon -> replaceFragment(homeScreen)
                R.id.search_icon -> replaceFragment(searchScreen)
                R.id.favourite_icon -> replaceFragment(favouriteScreen)
                R.id.setting_icon -> replaceFragment(settingScreen)
                else -> false
            }
        }
    }

    private fun initFragment() {
        inTransaction { add(R.id.fragment_container_view,homeScreen) }
    }

    private fun replaceFragment(fragment : Fragment) : Boolean {
        inTransaction { replace(R.id.fragment_container_view,fragment) }
        return true
    }
    protected fun inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        supportFragmentManager
            .beginTransaction()
            .func()
            .commit()
    }
}