package com.example.parkseeun.review.network

import com.example.parkseeun.review.post.GetBoardListResponse
import com.example.parkseeun.review.post.PostLogInResponse
import com.example.parkseeun.review.post.PostSignUpResponse
import com.example.parkseeun.review.post.PostWriteBoardResponse
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    //회원가입
    @POST("/users")
    fun postSignUpResponse(
        @Header("Content-Type") content_type : String,
        @Body() body: JsonObject
    ) : Call<PostSignUpResponse>

    @POST("/login")
    fun postLoginRsponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Call<PostLogInResponse>

    @Multipart
    @POST("/contents")
    fun postWriteBoardReponse(
        @Header("Authorization") token: String,
        @Part("title") title: RequestBody,
        @Part("contents") contents: RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<PostWriteBoardResponse>

    // 쿼리문
    // /contents?offset={offset}&limit={limit}
    @GET("/contents")
    fun getBoardListResponse(
        @Header("Content-Type") content_type : String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Call<GetBoardListResponse>


    // /contents/{offset}/{limit}이라면?
//    @GET("/contents/{offset}/{limit}")
//    fun getBoardListResponse(
//        @Header("Content-Type") content_type: String,
//        @Path("offset") offset : Int,
//        @Path("limit") limit : Int
//    ): Call<GetBoardListResponse>

}