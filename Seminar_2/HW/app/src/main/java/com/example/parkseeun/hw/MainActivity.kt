package com.example.parkseeun.hw

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_SIGN_UP_ACT = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupClickListener()
    }

    private fun setupClickListener() {
        btn_main_act_sign_up.setOnClickListener {
            val id: String = et_main_act_id.text.toString()
            startActivityForResult<SignUpActivity>(REQUEST_CODE_SIGN_UP_ACT, "ID" to id)
        }
        btn_main_act_sign_in.setOnClickListener {
            toast("로그인")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SIGN_UP_ACT) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    et_main_act_id.setText(data.getStringExtra("ID"))
                    et_main_act_pw.setText(data.getStringExtra("PW"))
                }
            }
        }
    }
}
