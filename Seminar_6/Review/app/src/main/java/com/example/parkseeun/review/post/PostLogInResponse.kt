package com.example.parkseeun.review.post

data class PostLogInResponse(
    val status: Int,
    val message: String,
    val data: LoginData
)
data class LoginData(
    val token: String
)