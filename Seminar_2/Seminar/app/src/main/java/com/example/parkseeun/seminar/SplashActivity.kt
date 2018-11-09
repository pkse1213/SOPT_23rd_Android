package com.example.parkseeun.seminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class  SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //apply = 생성과 동시에 초기화
        Handler().apply {

            // 인위적으로 2초정도(2000) 딜레이를 주는 것
            postDelayed({

                // anko가 없으면 상수를 만들어서 해야하고
//                var intent: Intent = Intent(this@SplashActivity, MainActivity::class.java)
//                intent.putExtra("data1","헬로우")
//                intent.putExtra("data2", "월드")
//                intent.putExtra("data3", 1000)
//                startActivity(intent)
                // 코틀린은 new가 없음


                // -------- anko가 있는 경우 ----------
                // command + p 는 매개변수를 보여줌
                startActivity<MainActivity>("data1" to "헬로우", "data2" to "월드", "data3" to 1000)
                finish() // 이걸 안해주면 밑에 splashActivity가 깔려있음
            }, 2000)
        }
    }
}