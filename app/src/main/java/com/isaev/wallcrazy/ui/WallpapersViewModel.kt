package com.isaev.wallcrazy.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.R
import com.isaev.wallcrazy.network.Image
import com.isaev.wallcrazy.network.ImagesServiceHelper
import kotlinx.coroutines.launch
import java.util.*

class WallpapersViewModel : ViewModel() {

    private val apiService = ImagesServiceHelper

    private val _images: MutableLiveData<List<Image>> = MutableLiveData()
    val images: LiveData<List<Image>> = _images

    fun getImages(category: String) {
        try {
            viewModelScope.launch {
                val fetchedImages =
                    apiService.getImages(Category(category.lowercase(Locale.ROOT), R.drawable.music_heart), 1)
                _images.value = fetchedImages

                Log.i(TAG, images.toString())
            }
        } catch (e: java.lang.Exception) {
            Log.i(TAG, e.toString())
        }
    }

    companion object {
        const val TAG = "WallpapersViewModel"
    }
}