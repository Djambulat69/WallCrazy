package com.isaev.wallcrazy.ui

import android.app.WallpaperManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.isaev.wallcrazy.databinding.ActivityFullWallpaperBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class FullWallpaperActivity : AppCompatActivity() {

    private val viewModel: FullWallpaperViewModel by lazy {
        ViewModelProvider(this).get(FullWallpaperViewModel::class.java)
    }

    private lateinit var binding: ActivityFullWallpaperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.loadImage(
                Json.decodeFromString(intent.getStringExtra(WALLPAPER_EXTRA)!!)
            )
        }

        binding = ActivityFullWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.wallpaper.observe(this) { img ->

            Glide.with(this)
                .asBitmap()
                .load(img.largeUrl)
                .thumbnail(Glide.with(this).asBitmap().load(img.webformatUrl))
                .into(binding.wallpaper)

            binding.views.text = img.views.toString()
            binding.downloads.text = img.downloads.toString()
        }

        binding.setAsWallpaperButton.setOnClickListener {
            Glide.with(this@FullWallpaperActivity)
                .asBitmap()
                .load(viewModel.wallpaper.value?.largeUrl)
                .submit().let { future ->
                    lifecycleScope.launch(Dispatchers.IO) {
                        WallpaperManager.getInstance(this@FullWallpaperActivity)
                            .setBitmap(future.get())
                    }
                }
        }
    }

    companion object {
        const val WALLPAPER_EXTRA = "wallpaper extra"
    }
}
