package com.example.masala_food_recipes


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import com.example.masala_food_recipes.data.DataManager
import com.example.masala_food_recipes.databinding.ActivityMainBinding

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController by lazy {
        findNavController(R.id.fragment_container_view)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPref = this.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE)
        if (sharedPref.getBoolean("current_state", false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewModel: GlobalViewModel by viewModels()
        viewModel.recipes = DataManager(this).getAllRecipesData()

    }


    @SuppressLint("SuspiciousIndentation")
    override fun onResume() {
        super.onResume()
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.searchFragment -> {
                    navController.navigate(R.id.searchFragment)
                    true
                }
                R.id.favouriteFragment -> {
                    navController.navigate(R.id.favouriteFragment)
                    true
                }
                R.id.settingFragment -> {
                    navController.navigate(R.id.settingFragment)
                    true
                }
                else -> false
            }
        }
        binding.bottomNavigation.setOnItemReselectedListener {
            // Handle reselection of the item
            null
            // do nothing
        }

    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val currentFragmentId = navController.currentDestination?.id
        if (currentFragmentId == R.id.homeFragment) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to exit?").setCancelable(false)
                .setPositiveButton("Yes") { _, _ -> finish() }
                .setNegativeButton("No") { dialog, _ -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        } else navController.popBackStack()
    }
}
