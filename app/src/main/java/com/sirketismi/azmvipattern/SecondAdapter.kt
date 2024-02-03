package com.sirketismi.azmvipattern

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirketismi.azmvipattern.databinding.ListItemTempBinding
import java.lang.Exception

class SecondAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        throw Exception()
    }

    override fun getItemCount(): Int {
        throw Exception()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        throw Exception()
    }
}

class CustomViewHolder(val itemBinding : ListItemTempBinding) : RecyclerView.ViewHolder(itemBinding.root) {

}