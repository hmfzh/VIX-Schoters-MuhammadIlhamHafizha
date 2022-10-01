package com.example.vix_schoters_muhammadilhamhafizha.network

import com.example.vix_schoters_muhammadilhamhafizha.BuildConfig
import com.example.vix_schoters_muhammadilhamhafizha.model.ArticleModel
import com.example.vix_schoters_muhammadilhamhafizha.model.NewsModel
import com.example.vix_schoters_muhammadilhamhafizha.room.NewsDao
import org.koin.dsl.module

val repositoryModul = module {
    factory {
        NewsRepository(get(),get())
    }
}

class NewsRepository(
    private val api: ApiClient,
    val db: NewsDao,

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

    suspend fun find(articleModel: ArticleModel) = db.find(articleModel.publishedAt)

    suspend fun save(articleModel: ArticleModel) {
        db.save( articleModel )
    }

    suspend fun remove(articleModel: ArticleModel) {
        db.remove( articleModel )
    }
}