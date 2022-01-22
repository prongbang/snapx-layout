package com.prongbang.snapxlayout

import android.graphics.Bitmap
import android.view.View
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

interface SnapXLayout {
    fun inflate(@LayoutRes layoutRes: Int): View
    fun snapshot(view: View): Bitmap
    fun snapshot(viewBinding: ViewBinding): Bitmap
    fun snapshot(@LayoutRes layoutRes: Int): Bitmap
}