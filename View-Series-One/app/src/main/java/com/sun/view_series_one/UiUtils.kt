package com.sun.view_series_one

import android.content.res.Resources
import android.hardware.display.DisplayManager
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Display

/**
 *
 * @author tianxiaolong
 * time：2020/4/23 11:14 PM
 * description：
 */
fun Float.dp2px():Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this,Resources.getSystem().displayMetrics)
}