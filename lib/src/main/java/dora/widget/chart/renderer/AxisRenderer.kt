package dora.widget.chart.renderer

import android.graphics.Canvas
import android.graphics.Paint
import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.BaseChartEntry
import dora.widget.chart.animation.ChartAnimator
import dora.widget.chart.component.XAxis
import dora.widget.chart.component.YAxis

abstract class AxisRenderer<E : BaseChartEntry, S : BaseChartDataSet<E>>(animator: ChartAnimator)
    : Renderer(animator) {

    protected val axisPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    abstract fun drawXAxis(xAxis: XAxis<E, S>, canvas: Canvas)
    abstract fun drawYAxis(yAxis: YAxis<E, S>, canvas: Canvas)
    abstract fun drawXAxisScaleValue(xAxis: XAxis<E, S>, canvas: Canvas)
    abstract fun drawYAxisScaleValue(yAxis: YAxis<E, S>, canvas: Canvas)
    abstract fun drawGridLine(xAxis: XAxis<E, S>, canvas: Canvas)
    abstract fun drawGridLine(yAxis: YAxis<E, S>, canvas: Canvas)

    override fun initPaints() {
        axisPaint.style = Paint.Style.STROKE
    }


    init {
        initPaints()
    }
}