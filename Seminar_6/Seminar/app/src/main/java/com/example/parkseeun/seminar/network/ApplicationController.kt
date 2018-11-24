package com.example.parkseeun.seminar.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController: Application() {

    private val baseURL = "http://bghgu.tk:8080/"

    // singleton패턴
    lateinit var networkService: NetworkService

    companion object {
        // singleton패턴
        // instance에 자기자신을 넣는다!!
        lateinit var instance: ApplicationController
    }

    // 가정 먼저 실행되는 함수이므로 여기에 자기자신을 instance에 넣고
    override fun onCreate() {
        super.onCreate()
        instance = this // 1. 앱이 실행되자 마자 instance에 자기자신을 넣는다!
        buildNetWork()
    }

    fun buildNetWork() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() // 빌드시키는 라이브러리
        // 이렇게 되면 레트로핏에 인스턴스 하나가 들어가는 형태
        networkService = retrofit.create(NetworkService::class.java) }
}