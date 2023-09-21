package com.isaev.wallcrazy.ui

import android.app.WallpaperManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.isaev.wallcrazy.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WallpaperOptionBottomSheetDialog :
    BottomSheetDialogFragment(R.layout.bottom_sheet_wallpaper_option) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = requireArguments().getString(WALLPAPER_URL_ARG)!!

        val homeOption = view.findViewById<TextView>(R.id.home_option)
        val lockOption = view.findViewById<TextView>(R.id.lock_option)
        val homeLockOption = view.findViewById<TextView>(R.id.home_lock_option)

        homeOption.setOnClickListener {
            Glide.with(this)
                .asBitmap()
                .load(url)
                .submit().let { future ->
                    lifecycleScope.launch(Dispatchers.IO) {
                        WallpaperManager.getInstance(requireContext())
                            .setBitmap(future.get(), null, false, WallpaperManager.FLAG_SYSTEM)
                    }
                }

            dismiss()
        }

        lockOption.setOnClickListener {
            Glide.with(this)
                .asBitmap()
                .load(url)
                .submit().let { future ->
                    lifecycleScope.launch(Dispatchers.IO) {
                        WallpaperManager.getInstance(requireContext())
                            .setBitmap(future.get(), null, false, WallpaperManager.FLAG_LOCK)
                    }
                }

            dismiss()
        }

        homeLockOption.setOnClickListener {
            Glide.with(this)
                .asBitmap()
                .load(url)
                .submit().let { future ->
                    lifecycleScope.launch(Dispatchers.IO) {
                        WallpaperManager.getInstance(requireContext())
                            .setBitmap(future.get())
                    }
                }

            dismiss()
        }
    }

    companion object {
        fun newInstance(url: String) = WallpaperOptionBottomSheetDialog().apply {
            arguments = bundleOf(WALLPAPER_URL_ARG to url)
        }

        const val WALLPAPER_URL_ARG = "wallpaper url"
    }

}