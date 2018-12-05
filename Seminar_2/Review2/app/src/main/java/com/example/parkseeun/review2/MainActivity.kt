package com.example.parkseeun.review2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.parkseeun.review2.fragment.HomeFragment
import com.example.parkseeun.review2.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE_SUB_ACTIVITY = 777
    var backPressedTime: Long = 0
    var message: String? = null
    var mynum: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        intent.getStringExtra("message")?.let {
            message = it
        }

        intent.getIntExtra("my number", 0)?.let {
            mynum = it
        }


        toast("$message, $mynum")

        setViewClickListener()
        addFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main_fragment_block, fragment)
        transaction.commit()
    }


    private fun addFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fl_main_fragment_block, fragment)
        transaction.commit()

    }


    private fun setViewClickListener() {
        btn_home.setOnClickListener {
            replaceFragment(HomeFragment())
        }
        btn_user.setOnClickListener {
            replaceFragment(UserFragment())
        }
        btn_main.setOnClickListener {
            startActivityForResult<SubActivity>(REQUEST_CODE_SUB_ACTIVITY, "message" to "아아~")
        }
    }

    override fun onBackPressed() {
        var temp: Long = System.currentTimeMillis()
        var intervalTime: Long = temp - backPressedTime

        if (intervalTime in 0..2000) {
            super.onBackPressed()
        } else {
            backPressedTime = temp
            toast("버튼을 한번 더 누르면 종료됩니다.")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SUB_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                tv_main.text = data!!.getStringExtra("result")
            } else {
                tv_main.text = "ok가 아니래!"
            }
        }
    }
}
