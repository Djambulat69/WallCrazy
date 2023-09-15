package com.isaev.wallcrazy.ui


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.isaev.wallcrazy.databinding.ImageListItemBinding

class ImageItemViewHolder(private val binding: ImageListItemBinding) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            binding.root.context.startActivity(
                Intent(binding.root.context, WallpapersActivity::class.java)
            )
        }
    }

    fun bind(text: String) {
        binding.title.text = text
    }

    fun bind(text: String, imageUrl: String) {
        binding.title.text = text
        Glide.with(binding.root.context).load(imageUrl).into(binding.picture)
    }
}