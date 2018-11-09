package com.example.parkseeun.hw

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val initId = intent.getStringExtra("ID")
        et_sign_up_act_id.setText(initId)

        setupClickListener()
    }

    private fun setupClickListener() {
        btn_sign_up_act_complete.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("ID", et_sign_up_act_id.text.toString())
            intent.putExtra("PW", et_sign_up_act_pw.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btn_sign_up_act_close.setOnClickListener {
            finish()
        }
    }
}
