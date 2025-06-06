package dora.widget.chart

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import dora.widget.chart.animation.ChartAnimator
import dora.widget.chart.component.Legend
import dora.widget.chart.formatter.IntValueFormatter
import dora.widget.chart.formatter.IValueFormatter
import dora.widget.chart.renderer.DataRenderer
import dora.widget.chart.renderer.LegendRenderer
import kotlin.properties.Delegates

abstract class BaseChartView<E : BaseChartEntry, S : BaseChartDataSet<E>,
        T : BaseChartData<E, S>>
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                          defStyleAttr: Int = 0) : ViewGroup(context,
        attrs, defStyleAttr) {

    private lateinit var legend: Legend
    lateinit var dataRenderer: DataRenderer
    lateinit var legendRenderer: LegendRenderer
    lateinit var animator: ChartAnimator
    internal var valueFormatter: IValueFormatter = IntValueFormatter()
    internal var data: T by Delegates.notNull()

    fun setValueFormatter(formatter: IValueFormatter) {
        this.valueFormatter = formatter
    }

    fun setData(data: T) {
        this.data = data
        postInvalidate()
    }

    fun setLegend(legend: Legend) {
        this.legend = legend
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (data == null) {
            return
        }
        dataRenderer.drawShape(canvas)
        dataRenderer.drawLabel(canvas)
        legendRenderer.drawLegend(legend, canvas)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        for (i in 0 until childCount) {
            getChildAt(i).layout(left, top, right, bottom)
        }
    }

    protected abstract fun createDataRenderer() : DataRenderer

    protected open fun init() {
        // 没有子控件可绘制且不设置背景的情况下，也要让ViewGroup调用onDraw
        // 预留将子控件作为图层进行绘制
        setWillNotDraw(false)
        legend = Legend()
        dataRenderer = createDataRenderer()
        animator = ChartAnimator { }
        legendRenderer = LegendRenderer(animator)
    }

    init {
        init()
    }
}