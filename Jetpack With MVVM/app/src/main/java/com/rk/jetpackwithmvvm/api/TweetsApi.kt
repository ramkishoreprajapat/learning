package com.rk.jetpackwithmvvm.api

import com.rk.jetpackwithmvvm.model.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {
    @GET("/v3/b/66d7c7fdacd3cb34a87e2b19?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>

    @GET("/v3/b/66d7c7fdacd3cb34a87e2b19?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>

}