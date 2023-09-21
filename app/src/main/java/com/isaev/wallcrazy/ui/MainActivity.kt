package com.isaev.wallcrazy.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.isaev.wallcrazy.R
import com.isaev.wallcrazy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val prefs = getSharedPreferences(SettingsActivity.SETTINGS_PREF_NAME, Context.MODE_PRIVATE)
        if (prefs.getString(
                SettingsActivity.THEME_PREF_KEY,
                SettingsActivity.THEME_DAY
            ) == SettingsActivity.THEME_NIGHT
        ) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        setContentView(binding.root)

        Log.i("Tag", "CREATED")

        binding.categoryList.adapter = CategoryListAdapter(viewModel)

        (binding.categoryList.adapter as CategoryListAdapter).submitList(
            viewModel.categories
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (item.itemId == R.id.settings_menu_item) {
            startActivity(Intent(this, SettingsActivity::class.java))
            true
        } else
            super.onOptionsItemSelected(item)
    }
}