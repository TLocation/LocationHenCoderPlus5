package com.sun.view_series_xfermode

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave

/**
 *
 * @author tianxiaolong
 * time：2020/4/25 10:34 PM
 * description：
 */
private const val  OFFSET =  100f
private const val OVER_WIDTH = 300f

class BitmapView(context: Context,attributeSet: AttributeSet? = null) :View(context,attributeSet) {

    private val bitmap  = getBitmap(resources,R.drawable.test3,300)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectf = RectF(OFFSET, OFFSET, OFFSET+OVER_WIDTH, OFFSET+OVER_WIDTH)
    private val modle = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    override fun onDraw(canvas: Canvas) {
        canvas.withLayer(rectf,paint){
            canvas.drawOval(rectf,paint)
            paint.xfermode = modle
            canvas.drawBitmap(bitmap,OFFSET,OFFSET,paint)
            paint.xfermode = null
        }
    }
}

fun getBitmap(resource:Resources,res:Int,width:Int = 0):Bitmap{
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resource,res,options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
    return BitmapFactory.decodeResource(resource,res,options)
}

inline fun Canvas.withLayer(bounds:RectF?,paint:Paint?,block:Canvas.() -> Unit){
    val count = saveLayer(bounds, paint)
    try {
        block()
    }finally {
        restoreToCount(count)
    }
}