package com.isaev.wallcrazy.ui

import androidx.lifecycle.ViewModel
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.R

class MainViewModel: ViewModel() {

    val categories: List<Category> = listOf(
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
}