package com.isaev.wallcrazy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.isaev.wallcrazy.DataResult
import com.isaev.wallcrazy.databinding.ActivityWallpapersBinding
import com.isaev.wallcrazy.network.Image


class WallpapersActivity : AppCompatActivity() {
    lateinit var binding: ActivityWallpapersBinding

    private val viewModel: WallpapersViewModel by lazy {
        ViewModelProvider(this).get(WallpapersViewModel::class.java)
    }

    private val category: String by lazy { intent.getStringExtra(CATEGORY_EXTRA) ?: CATEGORY_ALL }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.getImages(category)
        }

        binding = ActivityWallpapersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wallpapersList.adapter = WallpapersAdapter(viewModel)
        binding.wallpapersList.addItemDecoration(GridItemDecoration())

        binding.tryAgainButton.setOnClickListener {
            viewModel.getImages(category)
        }

        viewModel.images.observe(this) { wallPapersResult ->

            when (wallPapersResult) {
                is DataResult.Loading -> showLoading()
                is DataResult.Success -> showWallpapers(wallPapersResult.data)
                is DataResult.Failure -> showError()
            }

        }
    }

    private fun showWallpapers(wallpapers: List<Image>) {
        with(binding) {
            wallpapersList.isVisible = true

            progressBar.isVisible = false
            errorText.isVisible = false
            tryAgainButton.isVisible = false

            (binding.wallpapersList.adapter as WallpapersAdapter).submitList(
                wallpapers
            )
        }
    }

    private fun showLoading() {
        with(binding) {
            progressBar.isVisible = true

            wallpapersList.isVisible = false
            errorText.isVisible = false
            tryAgainButton.isVisible = false
        }
    }

    private fun showError() {
        with(binding) {
            errorText.isVisible = true
            tryAgainButton.isVisible = true

            progressBar.isVisible = false
            wallpapersList.isVisible = false
        }
    }


    companion object {
        const val CATEGORY_EXTRA = "category extra"
        private const val CATEGORY_ALL = "all"
    }
}
