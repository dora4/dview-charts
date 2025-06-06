package dora.widget.chart.renderer

import dora.widget.chart.animation.ChartAnimator

abstract class Renderer(val animator: ChartAnimator) {

    open fun init() {
    }

    open fun initPaints() {
    }
}