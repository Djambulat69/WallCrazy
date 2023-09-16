package com.isaev.wallcrazy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isaev.wallcrazy.network.Image


class FullWallpaperViewModel : ViewModel() {

    private val _wallpaper = MutableLiveData<Image>()

    val wallpaper: LiveData<Image> = _wallpaper

    fun loadImage(img: Image) {
        _wallpaper.value = img
    }
}
