package dora.widget

import dora.widget.chart.BaseChartEntry

class CurveEntry(value: Float = 0f, showValue: Boolean = false) : BaseChartEntry(value, showValue) {
    constructor(value: Float = 0f) : this(value, false)
}