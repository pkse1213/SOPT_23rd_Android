package com.example.parkseeun.seminar.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parkseeun.seminar.R

class UserFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_user, container, false)
        // !!는 널이 아니에요 강제 옵셔널?
        return view
    }
}