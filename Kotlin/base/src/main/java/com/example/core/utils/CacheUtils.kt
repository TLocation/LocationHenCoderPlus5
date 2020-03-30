package com.example.core.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:45
 * description：
 */
object CacheUtils {

    private val context: Context = BaseApplication.currentApplication()

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    operator fun get(key: String): String? {
        return SP.getString(key, null)
    }
}