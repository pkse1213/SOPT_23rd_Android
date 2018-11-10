package com.example.parkseeun.hw.db

import android.content.Context
import android.content.SharedPreferences


/*TODO
object는 생성자를 만들 수 없음
companion object만 생성자를 만들 수 있음

 */
object SharedPreferenceController {
    // 파일명같은 것 , 재사용을 위해서 사용함
    private val USER_NAME : String = "user_name"
    private val USER_ID : String = "user_id"
    private val USER_PW : String = "user_pw"

    // ID 집어 넣기
    fun setUserID(ctx: Context, input_id: String) {
        // context는 activity에 대한 가장 root에 있는 상세 정보?를 갖고 있는 객체
        // 일단은 activity라고 생각
        // preference를 통해 유저 정보? 인증 키 같은 것을 다른 앱에서도 참조를 할 수 있는데 previte모드로 하면 접근 불가
        // Preference를 참조 해야함
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit() // 값을 저장하거나 가져올 때 필요함
        editor.putString(USER_ID, input_id) // 앞 매개변수인 키 값에다가 뒤에 매개변수를 넣겠다
        editor.commit()
    }
    //PW 집어 넣기
    fun setUserPW(ctx: Context, input_pw: String) {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_PW, input_pw)
        editor.commit()
    }

    // ID 꺼내기
    fun getUserID(ctx: Context): String{
        // 꺼낼 떄도 프리퍼런슽를 참조해야함
        val preferences: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preferences.getString(USER_ID, "") // 만약 USER_ID에 값이 없으면 ""값을 넣겠다
    }

    //PW 꺼내기
    fun getUserPW(ctx: Context): String {
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preference.getString(USER_PW, "") // (키 명, 든게 없을때 리턴할 값)
    }

    // user_name 모든 데이터 제거
    fun clearUserSharedPreferences(ctx: Context) {
        val preferences: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit() // 값을 저장하거나 가져올 때 필요함
        editor.clear() // 전체 다 지우는 것이고, remove는 특정한 것만 지움
        editor.commit()
    }

}