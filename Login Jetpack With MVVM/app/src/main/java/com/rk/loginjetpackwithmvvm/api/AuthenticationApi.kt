package com.rk.loginjetpackwithmvvm.api

import com.rk.loginjetpackwithmvvm.data.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface AuthenticationApi {
    @GET("/api/v1/users_2279238366364924")
    @Headers("Content-Type: application/json")
    suspend fun register(): Response<User>
}