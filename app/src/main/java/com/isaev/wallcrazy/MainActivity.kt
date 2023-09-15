package com.isaev.wallcrazy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.isaev.wallcrazy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryList.addItemDecoration(GridItemDecoration())
        binding.categoryList.adapter = CategoryListAdapter()

        (binding.categoryList.adapter as CategoryListAdapter).submitList(
            listOf(
                Category("backgrounds"),
                Category("fashion"),
                Category("nature"),
                Category("science"),
                Category("education"),
                Category("feelings"),
                Category("health"), Category("people"),
                Category("religion"), Category("places"),
                Category("animals"), Category("industry"),
                Category("computer"),
                Category("food"),
                Category("sports"), Category("transportation"),
                Category("travel"), Category("buildings"), Category("business"), Category("music")
            )
        )
    }
}