package com.sun.view_series_one

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

/**
 *
 * @author tianxiaolong
 * time：2020/4/23 11:13 PM
 * description：
 */
private const val START_ANAGE = 135f
private const val SWEEP_ANGE = 360 - 90f
private val RADIOS = 120f.dp2px()
private  val LABLE_WIDTH  = 2.5f.dp2px()
private  val LABLE_HEIGHT  = 15f.dp2px()
private const val MAX_SIZE = 20
private const val LINE_LENGTH = 200f
class RoateView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val arcPath by lazy {
        Path().also {
            it.addArc(
                width / 2f - RADIOS,
                height / 2f - RADIOS,
                width / 2f + RADIOS,
                height / 2 + RADIOS,
                START_ANAGE,
                SWEEP_ANGE
            )

        }
    }

    private val paint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG).also {
            it.style = Paint.Style.STROKE
            it.strokeWidth = 3f.dp2px()
        }
    }


    private val lablePath by lazy {
        Path()
            .also {

                it.addRect(0f,0f, LABLE_WIDTH, LABLE_HEIGHT,Path.Direction.CCW)
            }
    }

     var ange = 2

    private val pathEffect by lazy {
        val pathMeasure = PathMeasure(arcPath, false)
        return@lazy PathDashPathEffect(lablePath,(pathMeasure.length- LABLE_WIDTH)/(MAX_SIZE -1),0f,PathDashPathEffect.Style.ROTATE) }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.pathEffect = pathEffect
        canvas.drawPath(arcPath, paint)
        paint.pathEffect = null
        canvas.drawPath(arcPath, paint)
        canvas.drawLine(width/2f,height/2f, width/2f+LINE_LENGTH*cos(Math.toRadians((SWEEP_ANGE/(MAX_SIZE -1) * (ange -1)+ START_ANAGE).toDouble()).toFloat()),height/2f+LINE_LENGTH*sin(Math.toRadians((SWEEP_ANGE/(MAX_SIZE -1) * (ange -1)+ START_ANAGE).toDouble()).toFloat()),paint)
    }
}