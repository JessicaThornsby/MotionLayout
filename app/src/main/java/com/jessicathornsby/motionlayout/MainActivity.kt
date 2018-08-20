package com.jessicathornsby.motionlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        motionLayout_container.setTransitionListener(
                object: MotionLayout.TransitionListener {

                    override fun onTransitionChange(motionLayout: MotionLayout?,
                                                    startId: Int,
                                                    endId: Int,
                                                    progress: Float) {
                        Log.d("TAG", "Progress:" + progress)
                    }

                    override fun onTransitionCompleted(motionLayout: MotionLayout?,
                                                       currentId: Int) {
                        if(currentId == R.id.ending_set) {
                            motionLayout_container.transitionToStart()
                        }
                    }
                }
        )
    }

    fun start(v: View) {
        motionLayout_container.transitionToEnd()
    }
}
