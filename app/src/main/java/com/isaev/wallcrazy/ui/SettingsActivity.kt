package com.isaev.wallcrazy.ui

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import com.isaev.wallcrazy.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val switch = findViewById<SwitchMaterial>(R.id.theme_switch)

        val prefs = getSharedPreferences(SETTINGS_PREF_NAME, Context.MODE_PRIVATE)

        switch.isChecked = prefs.getString(THEME_PREF_KEY, THEME_DAY) == THEME_NIGHT

        switch.setOnClickListener {
            val theme = prefs.getString(THEME_PREF_KEY, THEME_DAY)
            if (theme == THEME_DAY) {
                prefs.edit().putString(THEME_PREF_KEY, THEME_NIGHT).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                prefs.edit().putString(THEME_PREF_KEY, THEME_DAY).apply()
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    companion object {
        const val SETTINGS_PREF_NAME = "settings"
        const val THEME_PREF_KEY = "theme key"
        const val THEME_DAY = "day"
        const val THEME_NIGHT = "night"
    }
}