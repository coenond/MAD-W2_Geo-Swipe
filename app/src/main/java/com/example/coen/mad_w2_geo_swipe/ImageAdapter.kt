package com.example.coen.mad_w2_geo_swipe

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.list_item.view.*


class ImageAdapter(val items : ArrayList<CityImage>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val options = RequestOptions()
        options.centerCrop()
        Glide.with(context).load(items[position].resource).apply(options).into(holder.ivCity)
    }

    fun getItem(position: Int): CityImage {
        return items[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val ivCity = view.iv_cityImage
}