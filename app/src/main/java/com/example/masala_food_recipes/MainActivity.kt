package com.example.masala_food_recipes


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.masala_food_recipes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState : Bundle?) {
        val sharedPref = this.getSharedPreferences("MY_PREFS" , Context.MODE_PRIVATE)
        if (sharedPref.getBoolean("current_state" , false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    // Navigate Bottom bar  ("look at bottom_nav_menu")
    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container_view)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val navController = findNavController(R.id.fragment_container_view)
        val currentFragmentId = navController.currentDestination?.id
        if (currentFragmentId == R.id.homeFragment) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Are you sure you want to exit?").setCancelable(false)
                    .setPositiveButton("Yes") { _ , _ -> finish() }
                    .setNegativeButton("No") { dialog , _ -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        } else navController.popBackStack()

    }
}