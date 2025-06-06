package dora.widget

import android.graphics.Color
import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.LegendEntry

class CurveDataSet(
    entries: MutableList<CurveEntry> = arrayListOf(),
    var lineWidth: Float = 4f,
    var lineColor: Int = Color.BLACK,
    var label: String = "图例和注记",
    var labelColor: Int = Color.GRAY,
    var valueTextSize: Float = 30f,
    var valueTextColor: Int = Color.GRAY,
    var mode: Mode = Mode.LINEAR) : BaseChartDataSet<CurveEntry>(entries) {

    override fun calcLegend(): LegendEntry {
        return LegendEntry(label, labelColor, lineColor)
    }

    enum class Mode {
        LINEAR, CURVE
    }
}