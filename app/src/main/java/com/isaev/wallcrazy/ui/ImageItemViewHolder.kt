package com.isaev.wallcrazy.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.databinding.CategoryListItemBinding


class ImageItemViewHolder(
    private val binding: CategoryListItemBinding
) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            binding.root.context.startActivity(
                Intent(binding.root.context, WallpapersActivity::class.java)
            )
        }
    }

    fun bind(category: Category) {
        binding.title.text = category.name
        binding.picture.setImageResource(category.pic)
    }
}
