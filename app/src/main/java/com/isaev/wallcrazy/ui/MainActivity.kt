package com.isaev.wallcrazy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.R

import com.isaev.wallcrazy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("Tag", "CREATED")

        binding.categoryList.adapter = CategoryListAdapter()

        (binding.categoryList.adapter as CategoryListAdapter).submitList(
            listOf(
                Category("Backgrounds", R.drawable.backgrounds_sunflower),
                Category("Nature", R.drawable.nature_lovebird),
                Category("Science", R.drawable.science_binary),
                Category("Education", R.drawable.education_books),
                Category("People", R.drawable.people_women),
                Category("Places", R.drawable.places_mabry_mill),
                Category("Animals", R.drawable.animals_cheetah),
                Category("Food", R.drawable.food_cherries),
                Category("Music", R.drawable.music_heart)
            )
        )
    }
}