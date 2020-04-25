package com.sun.view_series_one

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import kotlin.math.cos
import kotlin.math.sin

/**
 *
 * @author tianxiaolong
 * time：2020/4/25 8:56 PM
 * description：
 */
private val RADIOS = 120f.dp2px()
private const val  OFFSET_LENGTH = 50
class PieView (context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private  val arcRect by lazy { RectF(width/2f- RADIOS,height/2f - RADIOS,width/2+ RADIOS,height/2f+ RADIOS) }

    private val list by lazy { mutableListOf(PieData(Color.RED,0.2f), PieData(Color.BLACK,0.3f),
        PieData(Color.BLUE,0.5f)
    ) }
    private val paint by lazy { Paint(Paint.ANTI_ALIAS_FLAG) }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var startAnge = 0f
        for ((index,data) in list.withIndex()){
            val sweepAnge  = 360*data.proportion
            if(index == 0){
                canvas.save()
                canvas.translate(OFFSET_LENGTH* cos(Math.toRadians((startAnge+sweepAnge/2f).toDouble()).toFloat()),OFFSET_LENGTH* sin(Math.toRadians((startAnge+sweepAnge/2f).toDouble()).toFloat()))
            }
            paint.color = data.color

            canvas.drawArc(arcRect,startAnge,sweepAnge,true,paint)
            startAnge+=sweepAnge
            if(index == 0){
                canvas.restore()
            }

        }
    }
}

data class PieData(val color:Int,val proportion:Float)