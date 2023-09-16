package com.isaev.wallcrazy.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.databinding.CategoryListItemBinding


class CategoryViewHolder(
    private val binding: CategoryListItemBinding,
    private val viewModel: MainViewModel
) : ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            binding.root.context.startActivity(
                Intent(binding.root.context, WallpapersActivity::class.java).apply {
                    putExtra(
                        WallpapersActivity.CATEGORY_EXTRA,
                        viewModel.categories[adapterPosition].name
                    )
                }
            )
        }
    }

    fun bind(category: Category) {
        binding.title.text = category.name
        binding.picture.setImageResource(category.pic)
    }
}
