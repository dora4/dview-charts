package dora.widget

import android.graphics.Color
import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.LegendEntry

class BarDataset(
    entries: MutableList<BarEntry> = arrayListOf(),
    var lineWidth: Float = 4f,
    var barWidth: Float = 60f,
    var barColor: Int = Color.GREEN,
    var signedBarColor: Int = Color.RED,
    var label: String = "",
    var labelColor: Int = Color.GRAY,
    var valueTextSize: Float = 30f,
    var valueTextColor: Int = Color.GRAY,
    var labelBarGap: Float = 15f) : BaseChartDataSet<BarEntry>(entries) {


    override fun calcLegend(): LegendEntry {
        return LegendEntry(label, labelColor, labelColor)
    }
}