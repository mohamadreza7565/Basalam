package com.example.basalam.utils

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.math.BigDecimal
import java.util.regex.Matcher
import java.util.regex.Pattern


class SetLocale {
    @SuppressLint("DefaultLocale")
    operator fun set(st: String, locale: String): String? {
        var st = st
        st = st.replace(",", "")
        st = st.replace("٬", "")
        try {
            st = String.format(
                "%" + locale + "d",
                java.lang.String.valueOf(BigDecimal(st).toBigIntegerExact()).toLong()
            )
        } catch (e: Exception) {
            try {
                st = String.format(
                    "%" + locale + "d",
                    java.lang.String.valueOf(BigDecimal(st).toBigIntegerExact()).toLong()
                )
            } catch (e1: Exception) {
            }
        }
        return st
    }

    @SuppressLint("DefaultLocale")
    operator fun set(number: Int, locale: String): String? {
        var st = number.toString()
        st = st.replace(",", "")
        st = st.replace("٬", "")
        try {
            st = String.format(
                "%" + locale + "d",
                java.lang.String.valueOf(BigDecimal(st).toBigIntegerExact()).toLong()
            )
        } catch (e: Exception) {
            try {
                st = String.format(
                    "%" + locale + "d",
                    java.lang.String.valueOf(BigDecimal(st).toBigIntegerExact()).toLong()
                )
            } catch (e1: Exception) {
            }
        }
        return st
    }

    fun replace(str: String?): String? {
        val p: Pattern = Pattern.compile("(\\d+)")
        val m: Matcher = p.matcher(str)
        var code = ""
        while (m.find()) {
            code = code + m.group(0)
        }
        return code
    }

    fun setLocaleEditText(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                editText.removeTextChangedListener(this) // Remove listener
                editText.setText(set(editText.text.toString(), ",")) // Set Text
                editText.setSelection(editText.text.toString().length) // Set selection
                editText.addTextChangedListener(this)
            }
        })
    }
}