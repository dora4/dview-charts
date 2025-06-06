package dora.widget.chart.component

import dora.widget.chart.BaseChartDataSet
import dora.widget.chart.BaseChartEntry

data class YAxis<E : BaseChartEntry, S : BaseChartDataSet<out E>>(var isShowLeft: Boolean = true,
                                                                  var isShowRight: Boolean = true,
                                                                      // 单边刻度值的数量，如果有正有负，则实际数量为sideScaleValueCount * 2 + 1
                                                                      // 反之，则实际数量为sideScaleValueCount + 1，因为y轴0轴是肯定要绘制的
                                                                  var sideScaleValueCount: Int = 2,
                                                                  var useFormattedScaleValue: Boolean = false) : Axis<E, S>()