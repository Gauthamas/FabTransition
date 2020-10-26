package com.example.fabtransition

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SampleMessagesAdapter(private val list: List<SampleMessage>)
    : RecyclerView.Adapter<SampleMessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleMessageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SampleMessageViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SampleMessageViewHolder, position: Int) {
        val sampleMessage: SampleMessage = list[position]
        holder.bind(sampleMessage)
    }

    override fun getItemCount(): Int = list.size

}

