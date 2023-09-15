package com.isaev.wallcrazy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.isaev.wallcrazy.databinding.ActivityWallpapersBinding


class WallpapersActivity : AppCompatActivity() {
    lateinit var binding: ActivityWallpapersBinding

    private val viewModel: WallpapersViewModel by lazy {
        ViewModelProvider(this).get(WallpapersViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWallpapersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wallpapersList.adapter = WallpapersAdapter()
        binding.wallpapersList.addItemDecoration(GridItemDecoration())

        viewModel.images.observe(this) { wallPapers ->
            (binding.wallpapersList.adapter as WallpapersAdapter).submitList(wallPapers)
        }
    }
}
