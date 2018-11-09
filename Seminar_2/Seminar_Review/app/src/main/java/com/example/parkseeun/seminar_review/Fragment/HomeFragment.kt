package com.example.parkseeun.seminar_review.Fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parkseeun.seminar_review.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.backgroundColor

// Fragment?
// Fragment는 FragmentManager에 의해 관리됨 -> add(), remove(), hide(), show(), replace() 등
// Fragment 내 Fragment는 childFragmentManager를 통해 관리
// 트렌젝션을 통해 관리가 이루어짐 -> commit을 통해 완료를 알림
class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // fragment 클래스 만들어주고 layout붙혀주기
        val homeFragmentView: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        return homeFragmentView
    }

    // View가 생성된 후 View를 건들 수 있는 곳은 onActivityCreated 함수 뿐
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rl_main_act_home_frag_background.backgroundColor = Color.parseColor("#BBDEFB")
        tv_main_act_home_frag_title.textSize = 18f
    }
}