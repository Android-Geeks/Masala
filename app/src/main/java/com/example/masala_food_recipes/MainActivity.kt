package com.example.masala_food_recipes


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.masala_food_recipes.databinding.ActivityMainBinding
import com.example.masala_food_recipes.ui.fragment.FavouriteFragment
import com.example.masala_food_recipes.ui.fragment.HomeFragment
import com.example.masala_food_recipes.ui.fragment.SearchFragment
import com.example.masala_food_recipes.ui.fragment.SettingFragment
import com.example.myapplication.DetailsScreen2

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeScreen = HomeFragment()
    private val favouriteScreen = FavouriteFragment()
    private val searchScreen = SearchFragment()
    private val settingScreen = SettingFragment()
    private lateinit var viewPager: ViewPager2
    private val fragments = listOf(DetailsScreen1(), DetailsScreen2())
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
        //initViewPager()
    }

    private fun init() {
        initFragment()
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
//    private fun initViewPager() {
//        val adapter = PagerAdapter(this, fragments)
//        viewPager = findViewById(R.id.viewPager)
//        viewPager.adapter = adapter
//    }

}