package com.example.parkseeun.review2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().apply {

            postDelayed({
                startActivity<MainActivity>("message" to "헬로", "my number" to 20)
                finish()
            } , 2000)

        }


    }
}
