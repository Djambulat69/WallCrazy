package com.isaev.wallcrazy.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.isaev.wallcrazy.R
import com.isaev.wallcrazy.databinding.WallpaperListItemBinding
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WallpaperViewHolder(
    private val binding: WallpaperListItemBinding,
    private val viewModel: WallpapersViewModel
) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            val img = viewModel.images.value?.get(adapterPosition)
            if (img != null) {
                binding.root.context.startActivity(
                    Intent(binding.root.context, FullWallpaperActivity::class.java).apply {
                        putExtra(FullWallpaperActivity.WALLPAPER_EXTRA, Json.encodeToString(img))
                    }
                )
            }
        }
    }

    fun bind(imageUrl: String) {
        Glide.with(binding.root.context)
            .load(imageUrl)
            .placeholder(R.drawable.image_icon)
            .into(binding.picture)
    }
}