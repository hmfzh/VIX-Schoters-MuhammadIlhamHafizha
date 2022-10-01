package com.example.vix_schoters_muhammadilhamhafizha.network

import com.example.vix_schoters_muhammadilhamhafizha.BuildConfig
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.model.NewsModel
import org.koin.dsl.module

val repositoryModul = module {
    factory {
        NewsRepository(get())
    }
}

class NewsRepository(
    private val api: ApiClient,

) {
    suspend fun fetch(
        key: String,
        page: Int,
    ): NewsModel {
        return api.fetchNews(
            BuildConfig.API_KEY,
            "id",
            "science",
            key,
            page
        )
    }
    }