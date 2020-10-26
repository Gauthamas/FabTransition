package com.example.fabtransition

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    companion object {
        private const val THRESHOLD_RECYCLERVIEW_Y = 500
        private const val FAB_ANIM_DURATION = 200L
    }
    private val messages = listOf(
            SampleMessage("This is first title", "This of course is the subtitle"),
            SampleMessage("This is second title", "Again Subtitle"),
            SampleMessage("This is third title", "Subtitle..."),
            SampleMessage("This is the fourth title", "Once again subtitle"),
            SampleMessage("This is the fifth title", "Once again subtitle"),
            SampleMessage("This is the sixth title", "Once again subtitle"),
            SampleMessage("This is the seventh title", "Once again subtitle"),
            SampleMessage("This is the eighth title", "Once again subtitle"),
            SampleMessage("This is the nineth title", "Once again subtitle"),
            SampleMessage("This is the tenth title", "Once again subtitle"),
            SampleMessage("This is the eleventh title", "Once again subtitle"),
            SampleMessage("This is the twelveth title", "Once again subtitle"),
            SampleMessage("This is the thirteenth title", "Once again subtitle"),
            SampleMessage("This is the fourteenth title", "Once again subtitle"),
            SampleMessage("This is the fifteenth title", "Once again subtitle"),
            SampleMessage("This is the sixteenth title", "Once again subtitle"),
            SampleMessage("This is the seventeenth title", "Once again subtitle"),
            SampleMessage("This is the eighteenth title", "Once again subtitle"),
            SampleMessage("This is the nineteenth title", "Once again subtitle"),
            SampleMessage("This is the twentieth title", "Once again subtitle"),
            SampleMessage("This is the twenty first title", "Once again subtitle"),
            SampleMessage("This is the twenty second title", "Once again subtitle"),
            SampleMessage("This is the twenty third title", "Once again subtitle"),
            SampleMessage("This is the twenty fourth title", "Once again subtitle"),
            SampleMessage("This is the twenty fifth title", "Once again subtitle"),
            SampleMessage("This is the twenty sixth title", "Once again subtitle"),
            SampleMessage("This is the twenty seventh title", "Once again subtitle")

    )

    private fun createWidthAnimator (start: Int, end: Int, view: TextView ): ValueAnimator {
        val anim = ValueAnimator.ofInt(start, end)
        anim.duration = FAB_ANIM_DURATION
        anim.addUpdateListener { animation ->
            view.layoutParams.width = animation?.animatedValue as Int
            view.setLayoutParams(view.layoutParams)
        }
        return anim
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var activity = this


        //Initial UI States
        var scrollY = 0
        var scrollState = RecyclerView.SCROLL_STATE_IDLE
        var expanded = true

        var mainActivity = this

        val sampleMessagesAdapter = SampleMessagesAdapter(messages)
        val recyclerView = findViewById<RecyclerView>(R.id.messages_recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = sampleMessagesAdapter
            addOnScrollListener(object: RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    scrollState = newState
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    scrollY += dy
                    if (expanded) {
                        if (dy >0 && scrollY > THRESHOLD_RECYCLERVIEW_Y) {
                            val view = mainActivity.findViewById<TextView>(R.id.expanded_fab)
                            val endWidth = mainActivity.resources.getDimensionPixelSize(R.dimen.dimen_56dp)
                            expanded = false
                            val anim = createWidthAnimator(view.measuredWidth, endWidth, view)
                            anim.start()

                        }
                    } else {
                        if (dy < 0 &&
                                scrollY < THRESHOLD_RECYCLERVIEW_Y) {
                            val view = mainActivity.findViewById<TextView>(R.id.expanded_fab)
                            val endWidth = mainActivity.resources.getDimensionPixelSize(R.dimen.dimen_160dp)
                            expanded = true
                            val anim = createWidthAnimator(view.measuredWidth, endWidth, view)
                            anim.start()

                        }
                    }
                }
            })
        }
        sampleMessagesAdapter.notifyDataSetChanged()
    }

}