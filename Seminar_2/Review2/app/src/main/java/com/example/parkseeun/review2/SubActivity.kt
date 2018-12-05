package com.example.parkseeun.review2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        setOnclickListener()
    }

    private fun setOnclickListener() {
        btn_sub.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("result", "sub가 주는 데이터")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}
