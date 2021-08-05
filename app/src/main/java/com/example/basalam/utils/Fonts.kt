package com.example.basalam.utils

import android.content.Context
import android.graphics.Typeface

class Fonts(val context: Context, val font: String) {

    companion object{
        val DIRECTORY_FONT = "fonts"
        val DEFAULT_FA_FONT = "iran_sans.ttf"
        val DEFAULT_EN_FONT = "tahoma.ttf"
        val BOLD_FA_FONT = "iran_sans_bold.ttf"
        val BOLD_EN_FONT = "tahoma_bold.ttf"
        val LIGHT_FONT = "iran_sans_light.ttf"
        val MOBILE_LIGHT_FONT = "IRANSansMobile_Light.ttf"
        val MOBILE_MEDIUM_FONT = "IRANSansMobile_Medium.ttf"
    }

    fun getTypeface(): Typeface =
        Typeface.createFromAsset(context.assets, DIRECTORY_FONT + "/" + font)

}