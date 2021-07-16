package com.example.basalam.custom_views


import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.example.basalam.data.DEFAULT_EN_FONT
import com.example.basalam.utils.Fonts

class Button : AppCompatButton {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr) {
        init()
    }

    private fun init() {
        setTypeface(Fonts(context, DEFAULT_EN_FONT).getTypeface())
    }

}