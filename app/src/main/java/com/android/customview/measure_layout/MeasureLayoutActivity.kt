package com.android.customview.measure_layout

import android.os.Bundle
import com.android.R
import com.kotlinlib.activity.KotlinActivity
import com.kotlinlib.other.LayoutId
import kotlinx.android.synthetic.main.activity_measure_layout.*

@LayoutId(R.layout.activity_measure_layout)
class MeasureLayoutActivity : KotlinActivity() {
    override fun init(bundle: Bundle?) {
        header1.setLeftClick {
            webDialog.url("MeasureSpec")
        }.setRightClick {
            codeDialog.text("""
override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    // 获取合适的宽度值
    val width = getProperSize(widthMeasureSpec)
    // 获取合适的高度值
    val height = getProperSize( heightMeasureSpec)
    // 设置宽高尺寸大小值，此方法决定view最终的尺寸大小
    setMeasuredDimension(width, height)

}

/**
 * 获取合适的大小
 */
private fun getProperSize( measureSpec: Int): Int {
    val mode = View.MeasureSpec.getMode(measureSpec)
    val size = View.MeasureSpec.getSize(measureSpec)
    return when (mode) {
        View.MeasureSpec.EXACTLY ->
            // 固定大小，无需更改其大小
            size
       else ->
            // 此处该值可以取小于等于最大值的任意值，此处取屏幕宽度的1/2
            context.srnWidth/4
    }
}
            """.trimIndent())
        }

        header2.setRightClick {
            codeDialog.text("""
    private var horizontalSpace = 0
    private var verticalSpace = 0

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.MyViewGroup)
        horizontalSpace = ta.getInt(R.styleable.MyViewGroup_horizontalSpace, 0)
        verticalSpace = ta.getInt(R.styleable.MyViewGroup_verticalSpace, 0)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var hadUsedHorizontal = 0//水平已经使用的距离
        var hadUsedVertical = 0//垂直已经使用的距离
        val width = measuredWidth
        //        int height = getMeasuredHeight();
        for (i in 0 until childCount) {
            val view = getChildAt(i)
            //判断是否已经超出宽度
            if (view.measuredWidth + hadUsedHorizontal > width) {
                //已经超出了宽度
                hadUsedVertical += view.measuredHeight + verticalSpace
                hadUsedHorizontal = 0
            }
            view.layout(hadUsedHorizontal, hadUsedVertical, hadUsedHorizontal + view.measuredWidth, hadUsedVertical + view.measuredHeight)
            hadUsedHorizontal += horizontalSpace + view.measuredWidth
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (i in 0 until childCount) {
            val view = getChildAt(i)
            measureChild(view, widthMeasureSpec, heightMeasureSpec)
        }
    }

    /**
     * @param child                   子View
     * @param parentWidthMeasureSpec  宽度测量规格
     * @param widthUsed               父view在宽度上已经使用的距离
     * @param parentHeightMeasureSpec 高度测量规格
     * @param heightUsed              父view在高度上已经使用的距离
     */
    override fun measureChildWithMargins(child: View, parentWidthMeasureSpec: Int, widthUsed: Int, parentHeightMeasureSpec: Int, heightUsed: Int) {
        super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed)
    }
            """.trimIndent())
        }
    }


}
