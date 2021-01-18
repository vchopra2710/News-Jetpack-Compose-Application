package com.proj.news.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.proj.news.R

fun getResBitmap(ctx: Context, id: Int?): Bitmap {
    val vector: Drawable? =
        ContextCompat.getDrawable(ctx, id ?: R.drawable.ic_launcher_foreground)
    vector?.setBounds(0, 0, vector.intrinsicWidth, vector.intrinsicHeight)

    val bitmap: Bitmap = Bitmap.createBitmap(
        vector?.intrinsicWidth ?: 0,
        vector?.intrinsicHeight ?: 0,
        Bitmap.Config.ARGB_8888
    )

    vector?.draw(Canvas(bitmap))

    return bitmap
}