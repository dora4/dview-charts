package dora.widget

import dora.widget.chart.BaseChartEntry

class BarEntry(value: Float = 0f, showValue: Boolean = false, val isFillBar: Boolean = true) : BaseChartEntry(value, showValue) {
    constructor(value: Float = 0f, isFillBar: Boolean = true) : this(value, false, isFillBar)
}