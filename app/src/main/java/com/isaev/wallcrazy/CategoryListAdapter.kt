package com.isaev.wallcrazy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.isaev.wallcrazy.databinding.ImageListItemBinding

class CategoryListAdapter : ListAdapter<Category, ImageItemViewHolder>(CategoryDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        val binding =
            ImageListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

        return ImageItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(getItem(position).name)
    }
}

object CategoryDiffUtil : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}