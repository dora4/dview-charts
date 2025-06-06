package dora.widget.chart.animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.view.animation.DecelerateInterpolator

class ChartAnimator (private val listener: ValueAnimator.AnimatorUpdateListener) {

    private var phaseX: Float = 1f
        set(value) {
            if (value > 1f) {
                field = 1f
            } else if (value < 0f) {
                field = 0f
            } else {
                field = value
            }
            field = value
        }
    private var phaseY: Float = 1f
        set(value) {
            if (value > 1f) {
                field = 1f
            } else if (value < 0f) {
                field = 0f
            } else {
                field = value
            }
            field = value
        }

    @SuppressLint("ObjectAnimatorBinding")
    fun xAnimator(duration: Long) : ObjectAnimator {
        val xAnimator = ObjectAnimator.ofFloat(this, "phaseX", 0f, 1f)
        xAnimator.interpolator = DecelerateInterpolator()
        xAnimator.duration = duration
        return xAnimator
    }

    @SuppressLint("ObjectAnimatorBinding")
    fun yAnimator(duration: Long) : ObjectAnimator {
        val yAnimator = ObjectAnimator.ofFloat(this, "phaseY", 0f, 1f)
        yAnimator.interpolator = DecelerateInterpolator()
        yAnimator.duration = duration
        return yAnimator
    }

    fun animateX(duration: Long) {
        val animator = xAnimator(duration)
        animator.addUpdateListener(listener)
        animator.start()
    }

    fun animateY(duration: Long) {
        val animator = yAnimator(duration)
        animator.addUpdateListener(listener)
        animator.start()
    }

    fun animateXY(xDuration: Long, yDuration: Long) {
        val xAnimator = yAnimator(xDuration)
        val yAnimator = yAnimator(yDuration)
        if (xDuration >= yDuration) {
            xAnimator.addUpdateListener(listener)
            xAnimator.start()
        } else {
            yAnimator.addUpdateListener(listener)
            yAnimator.start()
        }
    }

    companion object {
        const val ANIMATOR_TIME: Long = 1200L
    }
}