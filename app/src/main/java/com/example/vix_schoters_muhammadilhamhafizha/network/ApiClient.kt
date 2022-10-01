package com.example.vix_schoters_muhammadilhamhafizha.network

import com.example.vix_schoters_muhammadilhamhafizha.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("apiKey") apiKey : String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") q : String,
        @Query("page") page: Int /// max page from totalSize = 20 /page
    ) : NewsModel
}