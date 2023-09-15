package com.isaev.wallcrazy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.isaev.wallcrazy.databinding.ImageListItemBinding
import com.isaev.wallcrazy.network.Image

class WallpapersAdapter : ListAdapter<Image, ImageItemViewHolder>(ImageDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        val binding = ImageListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(position.toString(), getItem(position).largeUrl)
    }
}

object ImageDiffUtil : DiffUtil.ItemCallback<Image>() {

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id
    }
}