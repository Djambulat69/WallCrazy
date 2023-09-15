package com.isaev.wallcrazy.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.isaev.wallcrazy.databinding.ActivityWallpapersBinding

class WallpapersActivity : AppCompatActivity() {
    lateinit var binding: ActivityWallpapersBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityWallpapersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wallpapersList.addItemDecoration(GridItemDecoration())


    }
}