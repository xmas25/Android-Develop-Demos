package com.android.gesture.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.android.R
import com.kotlinlib.activity.ContextUtils


class PTP3View @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        View(context, attrs, defStyleAttr), ContextUtils{

    val paint = Paint()
    var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.mipmap.love)
    val mMatrix = Matrix()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(width/2f-bitmap.width/2f,height/2f-bitmap.height/2f)
        val bw = bitmap.width
        val bh = bitmap.height
        val src = floatArrayOf(0f, 0f, 0f, bh.toFloat(), bw.toFloat(), bh.toFloat())
        val dst = floatArrayOf(0f, 0f, 300f, bh.toFloat(), (bw + 300).toFloat(), bh.toFloat())
        mMatrix.setPolyToPoly(src, 0, dst, 0, 3)
        canvas?.drawBitmap(bitmap, mMatrix, paint)
    }

}