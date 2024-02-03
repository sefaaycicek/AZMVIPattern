package com.sirketismi.azmvipattern

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class FirstAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //treturn CustomViewHolder()
        throw Exception()
    }

    override fun getItemCount(): Int {
        throw Exception()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        throw Exception()
    }
}