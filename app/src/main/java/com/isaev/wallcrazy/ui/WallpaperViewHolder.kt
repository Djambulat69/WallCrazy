package com.isaev.wallcrazy.ui

import android.app.WallpaperManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.isaev.wallcrazy.databinding.WallpaperListItemBinding
import kotlinx.coroutines.*

class WallpaperViewHolder(
    private val binding: WallpaperListItemBinding
) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {  }
    }

    fun bind(imageUrl: String) {
        Glide.with(binding.root.context).load(imageUrl).into(binding.picture)

        binding.root.setOnLongClickListener {
            CoroutineScope(Job()).launch(Dispatchers.IO) {
                val imageBitmap = Glide.with(binding.root.context)
                    .asBitmap()
                    .load(imageUrl)
                    .submit()
                    .get()

                WallpaperManager.getInstance(binding.root.context)
                    .setBitmap(imageBitmap, null, false, WallpaperManager.FLAG_SYSTEM)

                withContext(Dispatchers.Main) {
                    Toast.makeText(binding.root.context, "Done", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnLongClickListener true
        }
    }
}