package com.example.masala_food_recipes


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
        setContentView(binding.root)

    }

    private fun init(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            initFragment()
        }
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            clearPreviousFragmentStack()
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
        inTransaction { add(R.id.fragment_container_view, homeScreen) }
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

    private fun clearPreviousFragmentStack() {
        while (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStackImmediate()
        }
    }
}


