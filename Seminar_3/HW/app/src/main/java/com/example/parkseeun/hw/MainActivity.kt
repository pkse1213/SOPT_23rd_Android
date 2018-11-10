package com.example.parkseeun.hw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.example.parkseeun.hw.adapter.InstagramRecyclerViewAdapter
import com.example.parkseeun.hw.data.MyItemData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var instagramRecyclerViewAdapter: InstagramRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
    }

    private fun setRecyclerView(){
        var dataList: ArrayList<MyItemData> = ArrayList()
        var like: Boolean = true
        for (i in 0..15) {
            dataList.add(MyItemData(i+1, !like))
        }

        instagramRecyclerViewAdapter = InstagramRecyclerViewAdapter(this, dataList)
        rv_main_frag_kakao_talk_room_list.adapter = instagramRecyclerViewAdapter
        rv_main_frag_kakao_talk_room_list.layoutManager = GridLayoutManager(this,3)
    }
}
