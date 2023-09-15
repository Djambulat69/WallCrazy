package com.isaev.wallcrazy


import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.isaev.wallcrazy.databinding.ImageListItemBinding

class ImageItemViewHolder(private val binding: ImageListItemBinding) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            
        }
    }

    fun bind(text: String) {
        binding.title.text = text
    }
}