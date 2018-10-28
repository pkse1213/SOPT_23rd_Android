package com.example.parkseeun.seminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.parkseeun.seminar.MainFragment
import com.example.parkseeun.seminar.MapFragment
import com.example.parkseeun.seminar.MyPageFragment


class MyFragmentSPAdapter(fm : FragmentManager, val fCount: Int) : FragmentStatePagerAdapter(fm) {
    // 오른쪽으로 슬라이드를 할 때마다 position이 1씩 올라가면서 들어옴
    override fun getItem(position: Int): Fragment? {
        //java의 switch
        when (position) {
            //position이 0일 때는 mainFragment를 return
            0 -> return MainFragment()
            //1 -> return MapFragment()
            1 -> {
                val mapFragment : Fragment = MapFragment()
                return mapFragment
            }
            2 -> return MyPageFragment()
            //else가 항상 필요함
            else -> return null
        }
    }

    //return fragmentCount의 의미임
    override fun getCount(): Int = fCount
}