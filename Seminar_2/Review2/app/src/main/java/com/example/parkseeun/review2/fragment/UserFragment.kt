package com.example.parkseeun.review2.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parkseeun.review2.R

class UserFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val userFragmentView: View = inflater!!.inflate(R.layout.fragment_user, container, false)

        return userFragmentView
    }


}