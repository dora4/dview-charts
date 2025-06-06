package dora.widget.chart.component

import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.BaseChartEntry

data class XAxis<E : BaseChartEntry, S : BaseChartDataSet<out E>>(val isShow: Boolean = true) : Axis<E, S>()