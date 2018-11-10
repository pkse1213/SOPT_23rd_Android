package com.example.parkseeun.hw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.parkseeun.hw.adapter.MemoRecyclerViewAdapter
import com.example.parkseeun.hw.data.MemoData
import com.example.parkseeun.hw.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_memo.*
import kotlinx.android.synthetic.main.rv_item_memo.*
import org.jetbrains.anko.startActivity

class MemoActivity : AppCompatActivity() {

    lateinit var memoRecyclerViewAdapter: MemoRecyclerViewAdapter

    // by lazy 사용하기 전까지 메모리할당되지 않고 사용하게 되면 할당 됨
    val dataList: ArrayList<MemoData> by lazy {
        ArrayList<MemoData>()
    }

    val str: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        // 밑으로 땡겼을 때
        srl_memo_act_refresh.setOnRefreshListener {
            // 서버 재통신 로직 넣기!
            srl_memo_act_refresh.isRefreshing = false
        }

        setOnBtnClickListener()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        memoRecyclerViewAdapter = MemoRecyclerViewAdapter(this, dataList)
        rv_memo_act_memo_list.adapter = memoRecyclerViewAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)
    }

    private fun setOnBtnClickListener() {
        btn_memo_act_logout.setOnClickListener {
            SharedPreferenceController.clearUserSharedPreferences(this)
            startActivity<LoginActivity>()
            finish()
        }
        btn_memo_act_add_memo.setOnClickListener {
            if (et_memo_act_title.text.toString().isNotEmpty() && et_memo_act_content.text.toString().isNotEmpty()) {

                val position: Int = memoRecyclerViewAdapter.dataList.size

                val title: String = tv_rv_item_memo_title.text.toString()
                val content: String = tv_rv_item_memo_content.text.toString()
                val memoData: MemoData = MemoData(title, content)

                memoRecyclerViewAdapter.dataList.add(memoData)
                memoRecyclerViewAdapter.notifyItemInserted(position) // 나는 position위치에 데이터를 추가 했다
            }
        }
    }
}
