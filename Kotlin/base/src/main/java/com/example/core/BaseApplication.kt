package com.example.core

import android.app.Application
import android.content.Context

/**
 *
 * @author tianxiaolong
 * time：2020/3/30 22:34
 * description：
 */
class BaseApplication: Application() {
    companion object{
        private var currentApplication:Context? = null
        fun currentApplication() = currentApplication!!
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }
}