package com.example.parkseeun.review2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.parkseeun.review2.adapter.MainBottomTabPagerAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        configureBottomTab()
    }

    private fun configureBottomTab(){
        vp_state_act_view_pager.adapter = MainBottomTabPagerAdapter(supportFragmentManager, 2)
        vp_state_act_view_pager.offscreenPageLimit = 2
        tl_state_act_bottom_tab.setupWithViewPager(vp_state_act_view_pager)

        val bottomTabLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.bottom_tab_layout, null, false)

        tl_state_act_bottom_tab.getTabAt(0)!!.customView = bottomTabLayout.findViewById(R.id.rl_bottom_tab_left) as RelativeLayout
        tl_state_act_bottom_tab.getTabAt(1)!!.customView = bottomTabLayout.findViewById(R.id.rl_bottom_tab_right) as RelativeLayout
    }
}
