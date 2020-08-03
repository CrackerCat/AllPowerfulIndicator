package com.ellen.indicator

import android.content.Context
import android.graphics.Color
import android.view.View

open class ItemTab {
    /**
     * Tab 布局
     */
    var itemLayout: Int = 0

    /**
     * 间隔
     */
    var itemSpacing: Int = 0

    /**
     * 模式
     * 对应TabLayout的模式
     */
    var itemMode:Mode = Mode.MODE_FIXED

    /**
     * Tab选中监听事件
     */
    var tabSelectListener:TabSelectListener? = null

    /**
     * 绑定的指示器控件
     */
    lateinit var allPowerIndicator:AllPowerIndicator

    /**
     * Tab的点击波纹效果的颜色
     */
    var tabRippleColor:Int = Color.GRAY

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    open fun dip2px(context: Context, dpValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    open fun px2dip(context: Context, pxValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

}

interface TabSelectListener {
    fun onTabReselected(position: Int, itemView: View)
    fun onTabUnselected(position: Int, itemView: View)
    fun onTabSelected(position: Int, itemView: View)
}

enum class Mode() {
    MODE_SCROLLABLE,
    MODE_FIXED,
    MODE_AUTO
}