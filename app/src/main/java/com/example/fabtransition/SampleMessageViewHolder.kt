package com.example.fabtransition

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SampleMessageViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.message_sample, parent, false)) {
    private var mTitleView: TextView? = null
    private var mSubtitleView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.title)
        mSubtitleView = itemView.findViewById(R.id.subtitle)
    }

    fun bind(message: SampleMessage) {
        mTitleView?.text = message.title
        mSubtitleView?.text = message.subtitle
    }

}