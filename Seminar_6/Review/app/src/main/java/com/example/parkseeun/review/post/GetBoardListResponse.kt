package com.example.parkseeun.review.post

import com.example.parkseeun.review.data.BoardData

data class GetBoardListResponse(
    val status: Int,
    val message: String,
    val data: ArrayList<BoardData>
)