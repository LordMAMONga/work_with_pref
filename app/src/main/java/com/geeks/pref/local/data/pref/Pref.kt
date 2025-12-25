package com.geeks.pref.local.data.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class Pref(context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences("555", Context.MODE_PRIVATE)

    fun saveCount(value: Int) {
        pref.edit { putInt("333", value) }
    }

    fun getCount() = pref.getInt("3", 0)
}