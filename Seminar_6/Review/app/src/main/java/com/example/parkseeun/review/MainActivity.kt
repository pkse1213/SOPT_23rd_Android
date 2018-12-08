package com.example.parkseeun.review

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener() {
        btn_main_act_log_in.setOnClickListener {
            startActivity<BoardActivity>()
        }

        btn_main_act_sign_up.setOnClickListener {
            startActivity<SignUpActivity>()
        }
    }
}
