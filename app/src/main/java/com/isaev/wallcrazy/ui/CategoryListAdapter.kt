package com.isaev.wallcrazy.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.databinding.CategoryListItemBinding

class CategoryListAdapter(private val viewModel: MainViewModel) :
    ListAdapter<Category, CategoryViewHolder>(CategoryDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

        return CategoryViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
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