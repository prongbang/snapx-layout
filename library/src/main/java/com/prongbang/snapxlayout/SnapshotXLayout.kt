package com.prongbang.snapxlayout

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

class SnapshotXLayout(
    private val context: Context
) : SnapXLayout {

    var width: Int = 1200
    var height: Int = 0
    var widthMeasureSpec: Int = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.AT_MOST)
    var heightMeasureSpec: Int =
        View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.UNSPECIFIED)
    var layoutParams: ViewGroup.LayoutParams? = null
    var bitmapConfig: Bitmap.Config? = null

    override fun inflate(@LayoutRes layoutRes: Int): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return inflater.inflate(layoutRes, null)
    }

    override fun snapshot(viewBinding: ViewBinding): Bitmap {
        return snapshot(viewBinding.root)
    }

    override fun snapshot(view: View): Bitmap {
        view.layoutParams = layoutParams ?: RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        view.measure(widthMeasureSpec, heightMeasureSpec)

        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        val bitmap = Bitmap.createBitmap(
            view.measuredWidth,
            view.measuredHeight,
            bitmapConfig ?: Bitmap.Config.ARGB_8888
        )

        val canvas = Canvas(bitmap)
        view.layout(view.left, view.top, view.right, view.bottom)
        view.draw(canvas)

        return bitmap
    }

    override fun snapshot(@LayoutRes layoutRes: Int): Bitmap {
        return snapshot(inflate(layoutRes))
    }

}