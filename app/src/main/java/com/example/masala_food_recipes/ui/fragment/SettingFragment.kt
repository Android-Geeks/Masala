package com.example.masala_food_recipes.ui.fragment

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.masala_food_recipes.databinding.FragmentSettingBinding

class SettingFragment :
    BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {
    override fun onCreateView() {
        val sharedPref = requireActivity()
            .getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE)

        val editor = sharedPref.edit()

        binding.darkSwitch.isChecked =
            sharedPref.getBoolean("current_state", false)

        binding.darkSwitch.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) {
                    editor.putBoolean("current_state", true)
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    editor.putBoolean("current_state", false)
                    AppCompatDelegate.MODE_NIGHT_NO
                }
            )
            editor.apply()
        }
    }
}