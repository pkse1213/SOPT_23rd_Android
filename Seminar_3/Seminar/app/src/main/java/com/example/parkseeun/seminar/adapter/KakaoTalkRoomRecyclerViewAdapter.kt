package com.example.parkseeun.seminar.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.parkseeun.seminar.data.KakaoTalkRoomData

class KakaoTalkRoomRecyclerViewAdapter(val ctx : Context, var dataList : ArrayList<KakaoTalkRoomData>)
    : RecyclerView.Adapter<KakaoTalkRoomRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_kakao_talk_room, parent)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.person_cnt.text = dataList[position].person_cnt.toString()
        holder.time.text = dataList[position].time
    }

    // inner 를 안쓰고도 중첩클래스를 만들 수 있음
    // 클래스 안에 클래스르 만드는 것 (원래는 정적(static)으로 만들어지는데 inner는 정적이 아니게 만들어짐)
    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_content) as TextView
        val person_cnt : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_person_cnt) as TextView
        val time : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_time) as TextView
    }
}
