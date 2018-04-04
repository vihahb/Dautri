package com.xproject.dautri

import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*


class StartActivity : AppCompatActivity() {

    var animatorSet: AnimatorSet? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        initProgressBar()
    }

    private fun initProgressBar() {
//        progressLoading.isScrollContainer = false
        progressLoading.setOnTouchListener { view, motionEvent -> true }
        val totalProgress = 100
        var currentProgress = 0

//        val anims = ValueAnimator.ofInt(0, progressLoading.max)
//        anims.duration = 1000
//        anims.addUpdateListener { animation ->
//            val animProgress = animation.animatedValue as Int
//            progressLoading.progress = animProgress
//        }

//        var anim = ProgressBarAnimation(progressLoading, currentProgress.toFloat(), totalProgress.toFloat())
//        anim.duration = 500
//        progressLoading.startAnimation(anim)

        val thread = object : Thread() {
            @SuppressLint("SetTextI18n")
            override fun run() {
                demoProgressBar(currentProgress, totalProgress)
            }
        }
        thread.start()
    }

    private fun demoProgressBar(currentProgress: Int, totalProgress: Int) {
        var currentProgress1 = currentProgress
        while (currentProgress1 < totalProgress) {
            try {
                Thread.sleep(300)
                currentProgress1++
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    progressLoading.setProgress(currentProgress1, true)
                    setPercent(currentProgress1)
                } else {
                    progressLoading.progress = currentProgress1
                    setPercent(currentProgress1)
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    private fun setPercent(currentProgress: Int) {
        runOnUiThread {
            tv_percent.text = "$currentProgress%"
        }
    }
}
