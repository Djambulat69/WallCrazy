package com.isaev.wallcrazy.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isaev.wallcrazy.Category
import com.isaev.wallcrazy.DataResult
import com.isaev.wallcrazy.R
import com.isaev.wallcrazy.network.Image
import com.isaev.wallcrazy.network.ImagesServiceHelper
import kotlinx.coroutines.launch
import java.util.*

class WallpapersViewModel : ViewModel() {

    private val apiService = ImagesServiceHelper

    private val _images: MutableLiveData<DataResult<List<Image>>> = MutableLiveData()
    val images: LiveData<DataResult<List<Image>>> = _images

    fun getImages(category: String) {
        viewModelScope.launch {
            _images.value = DataResult.Loading
            try {
                val fetchedImages =
                    apiService.getImages(
                        Category(
                            category.lowercase(Locale.ROOT),
                            R.drawable.music_heart
                        ), 1
                    )

                _images.value = DataResult.Success(fetchedImages)
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
                _images.value = DataResult.Failure(e)
            }
        }

    }

    companion object {
        const val TAG = "WallpapersViewModel"
    }
}