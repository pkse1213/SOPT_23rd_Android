package com.example.parkseeun.hw.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.parkseeun.hw.R
import com.example.parkseeun.hw.data.MemoData
import java.lang.IndexOutOfBoundsException

class MemoRecyclerViewAdapter(var ctx: Context, var dataList: ArrayList<MemoData>): RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>(){
    // control + i 하면 오버라이딩 해야 할 함수가 나옴

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_memo, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    fun addNewItem(memoData: MemoData) {
        val position: Int = dataList.size
        dataList.add(memoData)
        notifyItemInserted(position)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) { // 누른 것에 대한 포지션
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content

        holder.whole_btn.setOnClickListener {
            // 너무 빨리 누르면 인ㅅ덱스 오류 뜨니깐 잡아줘야 함
            try {

                dataList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, dataList.size) // 제거된 후 크기를 넣어줘야 함
            } catch (e: IndexOutOfBoundsException) {
                Log.e("제거 중에 오류 ", e.toString())
            }
        }
    }

    // 이게 필요한 이유 onCreateViewHolder함수에서 view를 넣어서 Holder를 호출해야해서
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_rv_item_memo_title) as TextView
        val content: TextView = itemView.findViewById(R.id.tv_rv_item_memo_content) as TextView
        val whole_btn: RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_whole_box) as RelativeLayout
    }

}