package com.example.parkseeun.seminar.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.parkseeun.seminar.R

class HomeFragment : Fragment(){

    // singleton패턴 방식
    // 홈 화면이 메모리에 딱 하나만 생성됨
    companion object {
        var mInstance : HomeFragment? = null

        @Synchronized // static이라는 의미
        //하나만 생성되도록 해주는 것임. 다른 곳에서 생성해도 이거임
        fun getInstance() : HomeFragment {
            if (mInstance == null){
                mInstance = HomeFragment()
            }
            return mInstance!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater!!.inflate(R.layout.fragment_home, container, false)
        // !!는 널이 아니에요 강제 옵셔널?
        return view
    }
}