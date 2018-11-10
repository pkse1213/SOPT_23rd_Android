
package com.example.parkseeun.hw

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.parkseeun.hw.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setOnBtnClickListener()
        if (SharedPreferenceController.getUserID(this).isNotEmpty()){
            startActivity<MemoActivity>()
            finish()
        }
    }
    private fun setOnBtnClickListener(){
        //로그인 버튼
        btn_login_act_sign_in.setOnClickListener {
            val input_id : String = et_login_act_id.text.toString()
            val input_pw : String = et_login_act_pw.text.toString()
            //만약 서버가 존재한다면 여기서 로그인 성공 여부를 체크하겠죠?! //지금은 서버가 없으므로 공백인지 아닌지만 체크해줍니다!
            if (input_id.isNotEmpty() && input_pw.isNotEmpty()){
                SharedPreferenceController.setUserID(this, input_id)
                SharedPreferenceController.setUserPW(this, input_pw)
                startActivity<MemoActivity>()
                finish() }
        }
    }
}
