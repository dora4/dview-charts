package dora.widget.chart.component

import android.graphics.Color
import dora.widget.chart.BaseChartData
import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.BaseChartEntry

abstract class Axis<E : BaseChartEntry, S : BaseChartDataSet<out E>>(var axisLineColor: Int = Color.GRAY,
                                                                     var axisLineWidth: Float = 5f,
                                                                     var drawGridLine: Boolean = true) : BaseChartComponent() {
    fun calcMaxValue(data: BaseChartData<E, S>): Float {
        return data.calcMaxEntryValue()
    }

    fun calcMinValue(data: BaseChartData<E, S>): Float {
        return data.calcMinEntryValue()
    }
}