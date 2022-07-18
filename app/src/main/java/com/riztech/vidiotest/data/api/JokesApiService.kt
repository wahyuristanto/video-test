package com.riztech.vidiotest.data.api

import com.nioso.core.base.BaseResponse
import com.riztech.vidiotest.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApiService {
    @GET("categories")
    suspend fun getCategories(): List<String>

    @GET("search")
    suspend fun search(@Query("query") query: String): Response.SearchResult

    @GET("random")
    suspend fun getDetailCategory(@Query("category") category: String): Response.Jokes
}