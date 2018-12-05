package com.example.parkseeun.review2.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parkseeun.review2.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.backgroundColor

class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val homeFragmentView: View = inflater!!.inflate(R.layout.fragment_home, container, false)

        return homeFragmentView
    }

    //
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rl_main_act_home_frag_background.backgroundColor = Color.parseColor("#BBDEFB")
        tv_main_act_home_frag_title.textSize = 18f
    }
}