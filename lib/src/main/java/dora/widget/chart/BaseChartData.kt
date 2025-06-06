package dora.widget.chart

abstract class BaseChartData<out E : BaseChartEntry, S : BaseChartDataSet<out E>>(
        vararg var dataSets: S) {
    abstract fun calcMaxEntryValue() : Float
    abstract fun calcMinEntryValue() : Float
}