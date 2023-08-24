package com.example.masala_food_recipes


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.masala_food_recipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    // Navigate Bottom bar  ("look at bottom_nav_menu")
    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container_view)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}


//    private fun init(savedInstanceState: Bundle?) {
//        if(savedInstanceState == null) {
//            initFragment()
//        }
//        binding.bottomNavigation.setOnItemSelectedListener { item ->
//            clearPreviousFragmentStack()
//            when (item.itemId) {
//                R.id.home_icon -> replaceFragment(homeScreen)
//                R.id.search_icon -> replaceFragment(searchScreen)
//                R.id.favourite_icon -> replaceFragment(favouriteScreen)
//                R.id.setting_icon -> replaceFragment(settingScreen)
//                else -> false
//            }
//        }
//    }
//
//    private fun initFragment() {
//        inTransaction { add(R.id.fragment_container_view, homeScreen) }
//    }
//
//    private fun replaceFragment(fragment: Fragment): Boolean {
//        inTransaction { replace(R.id.fragment_container_view, fragment) }
//        return true
//    }
//
//    private fun inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
//        supportFragmentManager
//            .beginTransaction()
//            .func()
//            .commit()
//    }
//
//    private fun clearPreviousFragmentStack() {
//        while (supportFragmentManager.backStackEntryCount > 0) {
//            supportFragmentManager.popBackStackImmediate()
//        }
//    }
