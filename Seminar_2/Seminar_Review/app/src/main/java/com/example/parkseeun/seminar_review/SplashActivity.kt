package com.example.parkseeun.seminar_review

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // apply = 생성과 동시에 초기화
        Handler().apply{
            // 인위적으로 2초정도(2000) 딜레이를 주는 것
            postDelayed({

                // ----------------------anko가 없을 경우 상수를 만들어서 해야함------------------------
/*                val intent: Intent = Intent(this@SplashActivity, MainActivity::class.java)
                // message라는 key에 헬로우 메인이라는 value가 담겨 있음
                // intent는 value를 구분할 수 있도록 한 쌍의 (key,value)데이터로 이루어짐
                intent.putExtra("message", "헬로우 메인!!")
                intent.putExtra("myNumber", 100)

                // startActivity()는 intent 메시지 객체를 통해 새로운 Activity를 시
                startActivity(intent)
*/

// ----------------------anko가 있을 경우 ------------------------
                startActivity<MainActivity>("data1" to "헬로","data2" to "월드", "data3" to 1000)

                // 이걸 안해주면 밑에 splashActivity가 깔려있음
                finish()

            }, 2000)
        }
    }
}
