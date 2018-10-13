package com.example.parkseeun.seminar

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        // 버튼을 눌렀을 때 main에게 결과 이터를 보내는 로직
        btn_user_activity.setOnClickListener {
            (it as Button).text = "닫기"
            val intent: Intent = Intent()
            intent.putExtra("resdata1","user에서 보내는 결과 데이터")
            setResult(Activity.RESULT_OK, intent) // intent에 put한 것을 넣음
            finish()
        }
    }

}
