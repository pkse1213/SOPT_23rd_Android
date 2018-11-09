package com.example.parkseeun.seminar_review

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // xml파일에서 만든 버튼에 대한 클릭 함수
        btn_user_activity.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("result", "서브 act가 주는 데이")
            setResult(Activity.RESULT_OK, intent)

            // intent에 값을 넣어 mainAct 보낸 후 종료 finish()
            finish()
        }
    }
}
