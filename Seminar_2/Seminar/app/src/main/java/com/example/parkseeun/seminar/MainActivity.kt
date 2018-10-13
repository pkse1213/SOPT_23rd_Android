package com.example.parkseeun.seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.parkseeun.seminar.Fragment.HomeFragment
import com.example.parkseeun.seminar.Fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var data4 : Int = 0
    var data1: String? = null
    var data5: String? = null
    var REQUEST_CODE_USER_ACTIVITY = 1000 // request code , 어느 Activity에서 돌아오는지 판별하려고 보내주는 코드

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // fragment!!!
        addFragment(HomeFragment())

        btn_main_act_home_frag.setOnClickListener {
            replaceFragment(HomeFragment())
        }
        btn_main_act_user_frag.setOnClickListener {
            replaceFragment(UserFragment())
        }


        // 데이터 받기 intent 안에 어떤 데이터를 받을지 자동완성 됨 (Get)
        data1 = intent.getStringExtra("data1") // 헬로우
        val data2 = intent.getStringExtra("data2") // 월드
        val data3 = intent.getIntExtra("data3",0)

        // null처리 하는 방법 !! null이 아닐 때만 괄호 안으로 들어감
        intent.getStringExtra("data2")?.let {
            data5 = it
        }
        intent.getIntExtra("data3", 0)// 값이 없으면 0을 넣어주겠다

//        btn_main.setOnClickListener {
//            // 버튼을 눌렀을 때 수행할 로직 작성
//            startActivityForResult<UserActivity>(REQUEST_CODE_USER_ACTIVITY, "data1" to "안녕하세요!")
//
//            var intent : Intent = Intent(this, UserActivity::class.java)
//            intent.putExtra("data1", "안녕하세요!")
//            startActivityForResult(intent, REQUEST_CODE_USER_ACTIVITY)
//        }

    }

    // fragment 넣어줌 (id의 위치에)!!
    private fun addFragment(fragment : Fragment){
        // 꼬이는걸 방지하기 위해 트렌젝션을 사용
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_fragment, fragment )
        transaction.commit()
    }
    // fragment 교체
    private fun replaceFragment(fragment : Fragment){
        // 꼬이는걸 방지하기 위해 트렌젝션을 사용
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main_act_fragment, fragment )
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
    }

    // user activity에서 보낸 데이터를 받음
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // REQUEST_CODE_USER_ACTIVITY 보내줬던 거를 받아서 이게 userActivity에서 온거라는 것을 알음
        if (requestCode == 1004){
            if (resultCode == 100) { // 이거는 userActivity에서 보내주는 int값
                toast("성공!")
            } else if (resultCode == 200) {
                toast("실패!")
            } else if (resultCode == Activity.RESULT_OK) {
                toast("결과 코드 ok")
            }
        }

    }
}
