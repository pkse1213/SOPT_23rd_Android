package com.example.parkseeun.review2.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.parkseeun.review2.fragment.HomeFragment
import com.example.parkseeun.review2.fragment.UserFragment

class MainBottomTabPagerAdapter(fm: FragmentManager, private val fragNum: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        return when(position) {
            0 -> HomeFragment()
            1 -> UserFragment()
            else -> null
        }
    }

    override fun getCount(): Int = fragNum
}