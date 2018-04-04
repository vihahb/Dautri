package com.xproject.dautri

import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.SeekBar

class ProgressBarAnimation(private val progressBar: SeekBar, private val from: Float, private val to: Float) : Animation() {

    protected override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        super.applyTransformation(interpolatedTime, t)
        val value = from + (to - from) * interpolatedTime
        progressBar.progress = value.toInt()
    }

}