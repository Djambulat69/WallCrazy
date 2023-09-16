package com.isaev.wallcrazy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.isaev.wallcrazy.databinding.WallpaperListItemBinding
import com.isaev.wallcrazy.network.Image

class WallpapersAdapter : ListAdapter<Image, WallpaperViewHolder>(ImageDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperViewHolder {
        val binding = WallpaperListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WallpaperViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        holder.bind(getItem(position).largeUrl)
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