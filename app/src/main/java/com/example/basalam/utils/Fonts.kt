package com.example.basalam.utils

import android.content.Context
import android.graphics.Typeface
import com.example.basalam.data.DIRECTORY_FONT

class Fonts(val context: Context, val font: String) {

    fun getTypeface(): Typeface =
        Typeface.createFromAsset(context.assets, DIRECTORY_FONT + "/" + font)

}