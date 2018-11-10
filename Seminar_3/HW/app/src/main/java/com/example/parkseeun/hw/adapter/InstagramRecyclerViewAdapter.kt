package com.example.parkseeun.hw.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.parkseeun.hw.R
import com.example.parkseeun.hw.data.MyItemData

class InstagramRecyclerViewAdapter(val ctx: Context,
                                   val dataList: ArrayList<MyItemData>)
                                            : RecyclerView.Adapter<InstagramRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {

        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_instagram_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) { //뷰 바인딩!!
        holder.id.setText(dataList[position].counter)
        if (!dataList[position].isLike) {
            holder.like.visibility = View.GONE
        }

    }
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tv_id) as TextView
        val like: ImageView = itemView.findViewById(R.id.iv_like) as ImageView

    }


}