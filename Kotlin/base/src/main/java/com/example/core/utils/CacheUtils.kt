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


    private val SP  by lazy { BaseApplication.currentApplication.getSharedPreferences(BaseApplication.currentApplication.getString(R.string.app_name), Context.MODE_PRIVATE) }

    fun save(key: String, value: String?) {
        SP.edit().putString(key, value).apply()
    }

     fun get(key: String): String? {
        return SP.getString(key, null)
    }

    /**
     * operator 重载运算符
     * get set 代表的是下标重载
     * 类似集合可以通过list[1] = 2
     * 可以通过[]来获取值或者赋值
     * 赋值会自动调用set方法 最后一个值为赋值的类型 前面的参数为下标里面的参数
     * 获取值会自动调用get方法
     * 备注 方法名不可更改
     * 但要注重可读性
     */
    operator fun set(key:String,value:String?){
        val edit = SP.edit()
        edit.putString(key, value).apply()
    }
}