package com.example.parkseeun.seminar_review

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.parkseeun.seminar_review.Fragment.HomeFragment
import com.example.parkseeun.seminar_review.Fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    // mainActivity에서 두 번 뒤로 버튼을 눌렀을 때만 종료되도록 하기 위한 변수
    var backPressedTime: Long = 0

    // 어떤 activity에서 돌아오는 데이터인지 알기 위한 변수
    val REQUEST_CODE_SUB_ACTIVITY = 7777

    var data1 : String? = null

    var data3: Int = 0
    var data5 : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data1 = intent.getStringExtra("data1")
        data3 = intent.getIntExtra("data3", 0) // value값이 없으면 0을 넣음

         // data1 -> 헬로우 가져옴
         // Null처리 하는 방법 : data1의 value가 null이 아닌 경우에만 그 value(헬로우)가 data5에 들어감
         intent.getStringExtra("data1")?.let {
             data5 = it
         }
        // anko 사용 안할 때
/*
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("message" , "헬로우 서브")
        startActivityForResult(intent, REQUEST_CODE_SUB_ACTIVITY)
*/

        // anko 사용
        startActivityForResult<SubActivity>(REQUEST_CODE_SUB_ACTIVITY, "message" to "헬로우 서브")

        // fragment 추가!!
        addFragment(HomeFragment())

        // 버튼에 함수 추가
        setViewClickListener()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_SUB_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                // ok결과 받았을 때 처리
            } else {
                // ok 못 받았을 때 처리
            }
        }
    }

    // mainActivity에서 두 번 뒤로 버튼을 눌렀을 때만 종료되도록 하기 위한 함수
    // 2초 내에 2번 눌렀을 때만 종료!!!
    override fun onBackPressed() {
        super.onBackPressed()
        var temp: Long = System.currentTimeMillis()
        var intervalTime: Long = temp - backPressedTime

        if (intervalTime in 0..2000) {
            super.onBackPressed()
        } else {
            backPressedTime = temp
            toast("버튼을 한 번 더 누르면 종료됩니다.")
        }
    }

    // Fragment?
    // Fragment는 FragmentManager에 의해 관리됨 -> add(), remove(), hide(), show(), replace() 등
    // Fragment 내 Fragment는 childFragmentManager를 통해 관리
    // fragment를 붙히기 위한 함수 (재사용을 위해 함수로 선언)
    private fun addFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_fragment_block, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main_act_fragment_block, fragment)
        transaction.commit()
    }

    private fun setViewClickListener() {
        btn_main_act_user_frag.setOnClickListener {
            replaceFragment(UserFragment())
        }
        btn_main_act_home_frag.setOnClickListener {
            replaceFragment(HomeFragment())
        }
    }
}
